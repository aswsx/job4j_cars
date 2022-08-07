CREATE TABLE IF NOT EXISTS engines
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    email    VARCHAR NOT NULL,
    password TEXT    NOT NULL
);

CREATE TABLE IF NOT EXISTS cars
(
    id          SERIAL PRIMARY KEY,
    name        varchar(255),
    description TEXT,
    body        varchar(255),
    photo       BYTEA,
    engine_id   INT NOT NULL REFERENCES engines (id)
);

CREATE TABLE IF NOT EXISTS advertisements
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(255),
    sold        BOOLEAN,
    created     TIMESTAMP,
    photo       BYTEA,
    car_id      INT NOT NULL REFERENCES cars (id),
    user_id     INT NOT NULL REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS drivers
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS history_owners
(
    id        SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES drivers (id),
    car_id    INT NOT NULL REFERENCES cars (id)
);

