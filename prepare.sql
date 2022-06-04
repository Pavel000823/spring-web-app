BEGIN;
SET search_path TO hiber,public;
DROP TABLE IF EXISTS products;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost numeric(6, 2));
INSERT INTO products (title, cost) VALUES ('milk', 130.20);
INSERT INTO products (title, cost) VALUES ('coffee', 1200);
COMMIT;



