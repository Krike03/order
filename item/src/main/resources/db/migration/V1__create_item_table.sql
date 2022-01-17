create sequence IF NOT EXISTS item_seq start with 1 increment by 1;
create TABLE item (
                      id int default nextval('item_seq') primary key ,
                      name varchar(50),
                      description varchar(254),
                      amountStock int not null
);