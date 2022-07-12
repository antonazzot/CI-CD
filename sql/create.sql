CREATE TABLE customer (
	id serial4 NOT NULL,
	balance numeric(19, 2) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT customer_pkey null
);

CREATE TABLE orders (
	id int8 NOT NULL,
	coast numeric(19, 2) NULL,
	"name" varchar(255) NULL,
	customer_id int4 NULL,
	CONSTRAINT orders_pkey null
);