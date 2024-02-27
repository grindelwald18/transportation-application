CREATE TABLE transporters
(
    id         BIGSERIAL PRIMARY KEY,
    company_name    VARCHAR(255) NOT NULL,
    logo VARCHAR(512) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255),
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
CREATE TABLE delivery_methods(
    id BIGSERIAL PRIMARY KEY ,
    method VARCHAR(255) NOT NULL,
    tariff INT NOT NULL
);
CREATE TABLE transports(
    id BIGSERIAL PRIMARY KEY,
    capacity INT NOT NULL,
    delivery_method_id INT NOT NULL,
    speed INT NOT NULL,
    transport_name VARCHAR(255) NOT NULL,
    transporter_id INT NOT NULL,
    FOREIGN KEY (delivery_method_id) REFERENCES delivery_methods(id),
    FOREIGN KEY (transporter_id) REFERENCES transporters(id)
);
CREATE TABLE cargos(
    id BIGSERIAL PRIMARY KEY,
    length INT NOT NULL,
    width INT NOT NULL,
    height INT NOT NULL,
    weight INT NOT NULL
);
CREATE TABLE containers(
    id BIGSERIAL PRIMARY KEY,
    container_length INT NOT NULL,
    container_width INT NOT NULL,
    container_height INT NOT NULL,
    delivery_methods_id INT NOT NULL,
    cargo_id INT NOT NULL,
    cargo_amount INT NOT NULL,
    FOREIGN KEY (delivery_methods_id) REFERENCES delivery_methods(id),
    FOREIGN KEY (cargo_id) REFERENCES cargos(id)
);
