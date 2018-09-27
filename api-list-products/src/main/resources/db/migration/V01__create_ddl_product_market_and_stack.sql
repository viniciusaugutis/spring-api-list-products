CREATE TABLE IF NOT EXISTS product (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT
);

CREATE TABLE IF NOT EXISTS market (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS stack (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS product_market (
    product_id INTEGER NOT NULL,
    market_id INTEGER NOT NULL,
    PRIMARY KEY (product_id, market_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (market_id) REFERENCES market(id)
);

CREATE TABLE IF NOT EXISTS product_stack (
    product_id INTEGER NOT NULL,
    stack_id INTEGER NOT NULL,
    PRIMARY KEY (product_id, stack_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (stack_id) REFERENCES stack(id)
);