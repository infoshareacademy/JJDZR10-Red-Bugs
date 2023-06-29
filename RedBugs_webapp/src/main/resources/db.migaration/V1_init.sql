create table users (
    id bigserial,
    username varchar(30) not null unique,
    password varchar(30) not null ,
    email varchar(30) unique ,
    primary key (id)
);

