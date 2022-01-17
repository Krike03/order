create table city
(
    zipcode varchar(4) primary key,
    city_name varchar(20) not null
);

create sequence IF NOT EXISTS street_seq start with 1 increment by 1;
create table street
(
    id integer default nextval('street_seq') primary key,
    street_name varchar(50),
    fk_city_zipcode varchar(4),
    constraint fk_city foreign key (fk_city_zipcode) references city(zipcode)
);

create sequence IF NOT EXISTS address_seq start with 1 increment by 1;
create table address
(
    id integer default nextval('address_seq') primary key,
    house_number varchar(10),
    fk_street_id int,
    constraint fk_street foreign key (fk_street_id) references street(id)
);