create sequence IF NOT EXISTS price_seq start with 1 increment by 1;
create table price (
       id integer default nextval('price_seq') primary key ,
       price double precision not null ,
       currency varchar(5),
       date timestamp,
       fk_item int,
       constraint fk_item foreign key (fk_item) references item(id)
);