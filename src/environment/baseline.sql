CREATE TABLE user_ (
    userid int NOT NULL,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255),
    username varchar(255),
    password varchar(255),
    status int,
    usertype int);

CREATE TABLE customer (
    customerid int NOT NULL,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255),
    status int
);

CREATE TABLE stock (
    stockid int NOT NULL,
    product_id varchar(255),
    productname varchar(255),
    qty float,
    price float,
    liter float
);

CREATE TABLE sales(
    sale_id int NOT NULL,
    invoice_id varchar(255),
    customer_id int,
    product_id varchar(255),
    subtotal float
);

CREATE TABLE sales_items(
    sales_item_id int NOT NULL,
    invoice_id varchar(255),
    qty float,
    total float
)

ALTER TABLE user_ DROP COLUMN userid;
ALTER TABLE user_ ADD userid INT IDENTITY(1,1);

ALTER TABLE customer DROP COLUMN customerid;
ALTER TABLE customer ADD customerid INT IDENTITY(1,1);

ALTER TABLE stock DROP COLUMN stockid;
ALTER TABLE stock ADD stockid INT IDENTITY(1,1);

ALTER TABLE sales DROP COLUMN sale_id;
ALTER TABLE sales ADD sale_id INT IDENTITY(1,1);

ALTER TABLE sales_items DROP COLUMN sales_item_id;
ALTER TABLE sales_items ADD sales_item_id INT IDENTITY(1,1);

INSERT INTO user_ (firstname,lastname,email,username,password,status,usertype) VALUES ('manager','manager','manager@gmail.com','admin','123',1,1);
INSERT INTO user_ (firstname,lastname,email,username,password,status,usertype) VALUES ('Cashier','Cashier','Cashier@gmail.com','cashier','123',1,2);
INSERT INTO user_ (firstname,lastname,email,username,password,status,usertype) VALUES ('stockkeeper','stockkeeper','stockkeeper@gmail.com','stock','123',1,3);