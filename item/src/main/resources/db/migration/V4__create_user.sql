create sequence IF NOT EXISTS user_seq start with 1 increment by 1;
create table user12
(
    id integer default nextval('user_seq') primary key,
    first_name varchar(50),
    last_name varchar(50),
    email_address varchar(100),
    fk_address_id int,
    phone_number varchar(11),
    user_name varchar(50),
    password varchar(255),
    constraint fk_address foreign key (fk_address_id) references address(id)
);