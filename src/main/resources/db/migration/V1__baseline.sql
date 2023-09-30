create sequence HIBERNATE_SEQUENCE;

create table ACCOUNT_ENTITY
(
    ID       BIGINT not null primary key,
    EMAIL    varchar(255),
    PASSWORD varchar(255)
);

create table POLITICIAN_ENTITY
(
    ID                 BIGINT not null primary key,
    NAME               varchar(255),
    SURNAME            varchar(255),
    BIO                varchar(255),
    POLITICAL_PARTY    varchar(255),
    PROFILE_PHOTO_PATH varchar(255)
);

create table POST_ENTITY
(
    ID                   BIGINT not null primary key,
    POLITICIAN_ENTITY_ID BIGINT,
    TAG_ID               BIGINT,
    TYPE                 varchar(255),
    CONTENT              varchar(255),
    ATTITUDE             varchar(255),
    VIDEO_PATH           varchar(255),
    POSITIVE             integer,
    NEGATIVE             integer,
    NEUTRAL              integer,
    FOREIGN KEY (POLITICIAN_ENTITY_ID) REFERENCES POLITICIAN_ENTITY (ID)
);

create table EVENT_ENTITY
(
    ID                   BIGINT not null primary key,
    NAME                 varchar(255),
    OCCURRENCE_DATE      TIMESTAMP,
    POLITICIAN_ENTITY_ID BIGINT,
    FOREIGN KEY (POLITICIAN_ENTITY_ID) REFERENCES POLITICIAN_ENTITY (ID)
);
