CREATE TABLE suppliers(
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           contact_person VARCHAR(255),
                           email  VARCHAR(255),
                           phone  VARCHAR(255),
                           is_active BOOLEAN DEFAULT TRUE,
                           created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                           update_at  TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP

);