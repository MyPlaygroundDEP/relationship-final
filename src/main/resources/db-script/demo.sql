create table customer
(
    id      varchar(15) primary key,
    name    varchar(100) not null,
    address varchar(500) not null

);

create table contact
(
    contact_id int auto_increment primary key,
    customer_id varchar(15) ,
    contact varchar(15) ,
    constraint fk_customer foreign key (customer_id) references customer(id)
);

create table user
(
    username  varchar(100) primary key,
    name    varchar(200) not null,
    password varchar(200) not null
);

create table item
(
    code  varchar(50) primary key,
    name    varchar(100) not null,
    stock int not null,
    price decimal(9,2) not null
);

create table `order`
(
    customer_id varchar(15) not null,
    user_username varchar(15)  ,
    id varchar(10) primary key,
    constraint fk_o_customer foreign key (customer_id) references customer(id),
    constraint fk_o_user foreign key (user_username) references user(username)
);

create table order_item
(
    order_id varchar(15) not null,
    item_code varchar(15) not null,
    price decimal(9,2) not null,
    discount int not null,
    constraint fk_oi_order foreign key (order_id) references `order`(id),
    constraint fk_oi_item foreign key (item_code) references item(code),
    constraint pk_order_item primary key (order_id,item_code)
);
