CREATE TABLE users (
    id serial PRIMARY KEY,
    userName varchar(255),
    email varchar(255),
    name varchar(255),
    mobileNo bigint,
    password varchar(255),
    dateOfBirth date,
    address varchar(255)
);
