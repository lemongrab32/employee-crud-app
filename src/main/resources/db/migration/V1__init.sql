create table if not exists address
(
    apartment_number int          null,
    house_number     int          null,
    id               bigint auto_increment
        primary key,
    city             varchar(255) null,
    country          varchar(255) null,
    postal_code      varchar(255) null,
    street           varchar(255) null
);

create table if not exists employees
(
    salary     int          null,
    address_id bigint       null,
    id         bigint auto_increment
        primary key,
    email      varchar(255) null,
    first_name varchar(255) null,
    gender     varchar(255) null,
    last_name  varchar(255) null,
    post       varchar(255) null,
    constraint UK_rsvlaac3t8dn6ub004hsp8w91
        unique (address_id),
    constraint FKg100eb5o2yvgyegncsekuatg0
        foreign key (address_id) references address (id)
);