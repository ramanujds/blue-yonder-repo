create table if not exists product (
    id int primary key auto_increment,
    product_name varchar(100) not null,
    product_description varchar(100) not null,
    price float not null
);

-- add few records

insert into product (product_name, product_description, price) values ('Apple', 'Apple iPhone 12', 799.99);
insert into product (product_name, product_description, price) values ('Samsung', 'Samsung Galaxy S21', 699.99);
insert into product (product_name, product_description, price) values ('Google', 'Google Pixel 5', 699.99);
insert into product (product_name, product_description, price) values ('OnePlus', 'OnePlus 9 Pro', 1069.99);
insert into product (product_name, product_description, price) values ('Xiaomi', 'Xiaomi Mi 11', 899.99);
insert into product (product_name, product_description, price) values ('Huawei', 'Huawei P40 Pro', 899.99);
insert into product (product_name, product_description, price) values ('Sony', 'Sony Xperia 1 II', 1199.99);
insert into product (product_name, product_description, price) values ('Motorola', 'Motorola Edge Plus', 999.99);
insert into product (product_name, product_description, price) values ('LG', 'LG V60 ThinQ', 899.99);
insert into product (product_name, product_description, price) values ('Nokia', 'Nokia 8.3 5G', 699.99);