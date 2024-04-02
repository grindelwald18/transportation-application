CREATE TABLE balances
(
    id      BIGSERIAL PRIMARY KEY,
    balance DECIMAL(10, 5) NOT NULL
);

create table roles
(
    id   BIGSERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE clients
(
    id         BIGSERIAL PRIMARY KEY,
    surname    VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255),
    balance_id INT          NOT NULL,
    role_id    INT          NOT NULL,
    FOREIGN KEY (balance_id) REFERENCES balances (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
