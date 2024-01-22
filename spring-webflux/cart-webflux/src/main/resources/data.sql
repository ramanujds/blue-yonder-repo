create table if not exists cart_item(
id int primary key auto_increment,
product_name varchar(100) not null,
price float not null,
quantity int not null
);