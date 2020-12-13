create table slot(
    id UUID not null primary key,
    salleid UUID,
    userName varchar(200),
    isreserved boolean ,
    startat bigint,
    endat bigint
);