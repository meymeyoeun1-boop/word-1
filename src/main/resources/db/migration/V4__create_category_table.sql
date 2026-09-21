CREATE TABLE categories(
     id BIGSERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description VARCHAR(255),
     created_at TIMESTAMP WITHOUT TIME ZONE,
     update_at  TIMESTAMP WITHOUT TIME ZONE

);