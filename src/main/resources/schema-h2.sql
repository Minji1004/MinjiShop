DROP TABLE IF EXISTS MEMBER CASCADE;
DROP TABLE IF EXISTS ITEM CASCADE;

CREATE TABLE MEMBER
(
    MEMBER_ID            bigint      NOT NULL AUTO_INCREMENT,
    NAME                 varchar(10),
    CITY                 varchar(225),
    STREET               varchar(225),
    ZIPCODE              varchar(225),
    CREATED_DATE         datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    LAST_MODIFIED_DATE   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (MEMBER_ID)
);

CREATE TABLE ITEM
(
    ITEM_ID               bigint      NOT NULL AUTO_INCREMENT,
    DTYPE                 varchar(1)  NOT NULL,

    NAME                  varchar(20) NOT NULL,
    PRICE                 int         NOT NULL DEFAULT 0,
    STOCK_QUANTITY        int         NOT NULL DEFAULT 0,

    ARTIST                varchar(225),
    ETC                   varchar(225),
    AUTHOR                varchar(225),
    ISBN                  varchar(225),
    ACTOR                 varchar(225),
    DIRECTOR              varchar(225),
    CREATED_DATE          datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    LAST_MODIFIED_DATE    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (ITEM_ID)
);
