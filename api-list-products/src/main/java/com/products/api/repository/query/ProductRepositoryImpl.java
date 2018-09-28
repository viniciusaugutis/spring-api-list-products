package com.products.api.repository.query;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.products.api.model.Market;
import com.products.api.model.Product;
import com.products.api.repository.filter.ProductFilter;
import com.products.api.repository.projection.ProductSummary;

public class ProductRepositoryImpl implements ProductRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Object> filterProduct(ProductFilter productFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ProductSummary> criteria = builder.createQuery(ProductSummary.class);
		Root<Product> root = criteria.from(Product.class);

		CriteriaQuery<Market> criteriaQuery = builder.createQuery(Market.class);
		Root<Product> productRoot = criteriaQuery.from(Product.class);
		Join<Object, Object> productJoin = productRoot.join("targetMarket");
		CriteriaQuery<Market> cq = criteriaQuery.multiselect(productJoin);
		manager.createQuery(cq);

		criteria.select(builder.construct(ProductSummary.class, productJoin)).orderBy(builder.asc(root.get("id")));

		Predicate[] predicates = createRestrictions(productFilter, builder, root);
		criteria.where(predicates);
		criteria.groupBy(root.get("id"));

		TypedQuery<ProductSummary> query = manager.createQuery(criteria);
		addRestrictionsPage(query, pageable);

		return new PageImpl<>(query.getResultList().stream().distinct().collect(Collectors.toList()), pageable,
				total(productFilter));
	}

	private Predicate[] createRestrictions(ProductFilter productFilter, CriteriaBuilder builder, Root<Product> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(productFilter.getName())) {

			predicates.add(builder.like(builder.function("unaccent", String.class, root.get("name")),
					"%" + removeAccents(productFilter.getName().toLowerCase()) + "%"));
		}

		if (productFilter.getTargetMarket() != null) {
			Expression<Integer> marketExpression = root.join("targetMarket").get("id");
			predicates.add(marketExpression.in(productFilter.getTargetMarket()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	public String removeAccents(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	private void addRestrictionsPage(TypedQuery<?> query, Pageable pageable) {
		int actualPage = pageable.getPageNumber();
		int totalRegisterPerPage = pageable.getPageSize();
		int firstRegisterPage = actualPage * totalRegisterPerPage;

		query.setFirstResult(firstRegisterPage);
		query.setMaxResults(totalRegisterPerPage);
	}

	private Long total(ProductFilter productFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Product> root = criteria.from(Product.class);

		Predicate[] predicates = createRestrictions(productFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}
