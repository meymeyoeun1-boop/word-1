CREATE TABLE product (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DOUBLE PRECISION NOT NULL ,
                         description VARCHAR(255),
                         stock INTEGER,
                         created_at TIMESTAMP WITHOUT TIME ZONE,
                         update_at  TIMESTAMP WITHOUT TIME ZONE

);