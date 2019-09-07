create TABLE USERS (
    id serial primary key,
    email varchar(100) unique,
    password varchar(100)
);

create TABLE INGREDIENTS (
  id serial primary key,
  name varchar(100) unique,
  density double precision
);