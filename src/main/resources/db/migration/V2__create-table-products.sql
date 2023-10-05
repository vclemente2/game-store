CREATE TABLE tb_products(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(512),
    price DECIMAL(8,2) NOT NULL,
    stock BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES tb_categories(id)
);