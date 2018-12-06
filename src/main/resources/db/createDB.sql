CREATE SCHEMA assigmentDB;

use
assigmentDB;
drop table if exists customer_order
drop table if exists product
drop table if exists product_order

create table customer_order
(
  id          bigint not null auto_increment,
  version     bigint,
  email       varchar(255),
  placed_date datetime,
  primary key (id)
) engine=InnoDB;

create table product
(
  id            bigint not null auto_increment,
  version       bigint,
  name          varchar(255),
  product_price double precision,
  primary key (id)
) engine=InnoDB;

create table product_order
(
  product_price     double precision,
  customer_order_id bigint not null,
  product_id        bigint not null,
  primary key (customer_order_id, product_id)
) engine=InnoDB;

alter table product_order
  add constraint FKr8bii2rylb1hlectaxb1ly1ir foreign key (customer_order_id) references customer_order (id);

alter table product_order
  add constraint FKh73acsd9s5wp6l0e55td6jr1m foreign key (product_id) references product (id);
