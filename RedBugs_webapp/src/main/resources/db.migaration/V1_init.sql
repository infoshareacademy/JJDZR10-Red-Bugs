CREATE TABLE users (
    id bigserial,
    username varchar(30) not null unique,
    password varchar(30) not null ,
    email varchar(30) unique ,
    primary key (id)
);

CREATE TABLE roles (
    id serial,
    name varchar(50) not null ,
    primary key (id)
);

CREATE TABLE  user_roles (
    user_id bigint not null ,
    role_id int not null ,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values
    ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email)
values
    ('user', '$2a$/123456', 'user@gmail.com'),
    ('admin', '$2a$/123456', 'admin@gmail.com');

insert into user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2);