CREATE TABLE IF NOT EXISTS engines
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cars
(
    id          SERIAL PRIMARY KEY,
    name        varchar(255),
    description TEXT,
    body        varchar(50),
    photo       BYTEA,
    engine_id   INT NOT NULL REFERENCES engines (id)
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