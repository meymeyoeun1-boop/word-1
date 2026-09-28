ALTER TABLE product
ADD CONSTRAINT fk_product_category_id
FOREIGN KEY (category_id)
REFERENCES category(id)
ON DELETE SET NULL;