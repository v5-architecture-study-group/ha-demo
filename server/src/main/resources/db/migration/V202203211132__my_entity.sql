create table my_entity
(
    id           bigint       not null auto_increment primary key,
    my_timestamp datetime     not null,
    host         varchar(200) not null,
    message      varchar(200) not null
) engine = InnoDB;
