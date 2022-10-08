-- init data base (Postgres)

-- For hibernate
CREATE SEQUENCE hibernate_sequence;

create table genre(
    id serial primary key,
    name varchar(50) not null unique,
    image varchar
);

create table movie(
    id serial primary key,
    image varchar,
    title varchar(100) not null,
    creation_date date not null,
    calification int not null
);

create table movie_genre(
    id serial primary key,
    movie integer references movie(id),
    genre integer references genre(id)
);

create table character(
    id serial primary key,
    image varchar,
    name varchar(100) not null,
    age int,
    weight real,
    history varchar
);

create table characters_movies(
    id serial primary key,
    character integer references character(id),
    movie integer references movie(id)
);