
    create table resources (
        id int4 not null,
        checksum varchar(255),
        content BYTEA,
        contentType varchar(64),
        created timestamp,
        deleted_flag bool,
        description varchar(1024),
        filename varchar(1024),
        filesize varchar(64),
        primary key (id)
    );



create sequence hibernate_sequence;
