CREATE SCHEMA assigmentDB;

use
assigmentDB;
drop table if exists prod_order;
drop table if exists product_price;
drop table if exists product;
drop table if exists customer_order;

create table customer_order
(
  id          bigint not null auto_increment,
  version     bigint,
  email       varchar(255),
  placed_date datetime,
  primary key (id)
) engine=InnoDB;
create table prod_order
(
  product_id bigint not null,
  order_id   bigint not null,
  primary key (product_id, order_id)
) engine=InnoDB;

create table product
(
  id      bigint not null auto_increment,
  version bigint,
  name    varchar(255),
  primary key (id)
) engine=InnoDB;

create table product_price
(
  id            bigint not null auto_increment,
  version       bigint,
  price         double precision,
  price_at_date datetime,
  product_id    bigint,
  primary key (id)
) engine=InnoDB;

alter table prod_order
  add constraint FKr1reacdvqouohk1e0l908t4k2 foreign key (order_id) references customer_order (id);
alter table prod_order
  add constraint FK7eeb0nhx8jdvdak8tu6pa1l18 foreign key (product_id) references product (id);
alter table product_price
  add constraint FKeupemu63ifqfc4txkskyy1hyi foreign key (product_id) references product (id);
