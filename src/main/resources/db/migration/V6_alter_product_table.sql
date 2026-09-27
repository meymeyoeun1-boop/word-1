ALTER TABLE product
    ADD COLUMN category_id BIGINT,
    ADD COLUMN supplier_id BIGINT;

ALTER TABLE product
    ADD CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
            REFERENCES categories(id)
            ON DELETE SET NULL;

ALTER TABLE product
    ADD CONSTRAINT fk_product_supplier
        FOREIGN KEY (supplier_id)
            REFERENCES suppliers(id)
            ON DELETE SET NULL;