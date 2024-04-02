CREATE TABLE deliveries
(
    id           BIGSERIAL PRIMARY KEY,
    transport_id INT          NOT NULL,
    client_id    INT          NOT NULL,
    cargo_id     INT          NOT NULL,
    start_point  VARCHAR(255) NOT NULL,
    final_point  VARCHAR(255) NOT NULL,
    distance     INT          NOT NULL,
    send_time    TIMESTAMPTZ  NOT NULL,
    price        INT          NOT NULL,
    status       VARCHAR(255) NOT NULL,
    FOREIGN KEY (transport_id) REFERENCES transports (id),
    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (cargo_id) REFERENCES cargos (id)
);