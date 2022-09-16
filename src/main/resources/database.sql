SET GLOBAL time_zone = '+2:00';

CREATE DATABASE IF NOT EXISTS order_management_database;

use order_management_database;

CREATE TABLE IF NOT EXISTS client(
id bigint not null auto_increment,
name varchar(20) not null,
email varchar(20) not null,
address varchar(40) not null,
primary key (id)
);

CREATE TABLE IF NOT EXISTS product(
id bigint not null auto_increment,
name varchar(20) not null,
skuCode int not null,
price float not null,
primary key (id)
);

CREATE TABLE IF NOT EXISTS orderLine(
id bigint not null auto_increment,
product_id bigint,
quantity bigint not null,
primary key (id)
);

CREATE TABLE IF NOT EXISTS orders(
id bigint not null auto_increment,
client_id bigint not null,
orderLine_id bigint not null,
date_of_submission DATE not null,
primary key (id)
);

alter table orderLine add constraint fk_for_product foreign key (product_id) references product(id);
alter table orders add constraint fk_for_client foreign key (client_id) references client(id);
alter table orders add constraint fk_for_orderLine foreign key (orderLine_id) references orderLine(id);