create table "roles"
(
    id        integer      not null,
    authority varchar(255) not null,
    primary key (id)
);

insert into sfm."roles" (id, authority)
VALUES (1, 'ADMIN'), (2, 'USER');

create table "users"
(
    id           integer                      not null,
    username     varchar(255)                 not null,
    password     varchar(255)                 not null,
    email        varchar(255)                 not null,
    is_active    boolean                      not null,
    date_created date                         not null,
    role_id         integer references roles (id) not null,
    primary key (id, role_id)
);

insert into sfm."users" (id, username, password, email, is_active, date_created, role_id)
VALUES (1, 'mixelx', 'admin', 'mkbusi85@gmail.com', true, now(), 1);
