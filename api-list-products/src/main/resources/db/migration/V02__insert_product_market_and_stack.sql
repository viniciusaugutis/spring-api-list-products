INSERT INTO product (name, description) VALUES 
('Gubee Integrador', 'Ferramenta de integração para marketplaces'),
('Gubee Fretes', 'Ferramenta para gestão e calculo de fretes'),
('Gubee AntiFraude', 'Ferramenta especialistas em detecção e prevenção à fraude');

INSERT INTO market (name) VALUES 
('Ecommerce'), ('ERP'), ('Lojista que não desejam possuir ecommerce'),
('Loja fisica'), ('Telecom'), ('Venda direta'),
('Mobile First'), ('Digital Onboarding');

INSERT INTO stack (name) VALUES 
('Java 10'), ('Kotlin'), ('Kafka'),
('Event Stream'), ('Redis'), ('MongoDB'),
('NodeJS'), ('Big Data Analytics'), ('Hadoop'),
('Pig'), ('Cassandra');

INSERT INTO product_market (product_id, market_id) VALUES 
(1,1), (1,2), (1,3), (2,1), (2,2), (2,4),
(3,1), (3,5), (3,6), (3,7), (3,8);

INSERT INTO product_stack (product_id, stack_id) VALUES 
(1,1), (1,2), (1,3), (1,4), (1,5), (1,6),
(2,7), (2,6), (3,8), (3,9), (3,10), (3,11), (3,3);

