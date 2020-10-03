create table music(

    id bigserial primary key ,
    title varchar(1024),
    author varchar(1024),
    filename varchar(1024),
    added date,
    musicfile bytea
)
