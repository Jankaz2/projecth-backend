create sequence HIBERNATE_SEQUENCE;

create table USER_ENTITY
(
    id       BIGINT not null primary key,
    EMAIL    varchar(255),
    PASSWORD varchar(255)
);
