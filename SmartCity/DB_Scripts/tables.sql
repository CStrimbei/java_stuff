CREATE TABLE "users"
(
    id serial primary key,
    username varchar(50) unique,
    password varchar(50),
    fullName varchar(100)
);