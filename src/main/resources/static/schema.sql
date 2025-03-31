CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

CREATE TABLE categoria (
                           id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           nombre VARCHAR(50) NOT NULL
);

CREATE TABLE producto(
                         id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         nombre VARCHAR(150),
                         descripcion TEXT,
                         precio DECIMAL(10, 2) NOT NULL,
                         imagen_url VARCHAR(255),
                         categoria_id BIGINT NOT NULL,
                         FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE CASCADE
);

INSERT INTO categoria (nombre) VALUES ('Electrónica'), ('Ropa'), ('Hogar');

INSERT INTO producto (nombre, descripcion, precio, imagen_url, categoria_id) VALUES
                                                                                 ('Laptop Lenovo', 'Laptop potente para programadores', 1200.00, '/uploads/productos/laptop.jpg', 1),
                                                                                 ('Camiseta Negra', 'Camiseta de algodón cómoda', 15.99, '/uploads/productos/camiseta.jpg', 2),
                                                                                 ('Silla Gamer', 'Silla ergonómica para largas sesiones', 250.00, '/uploads/productos/silla.jpg', 3);

SELECT * FROM producto;