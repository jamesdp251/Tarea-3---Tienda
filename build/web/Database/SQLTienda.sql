CREATE DATABASE Tienda;

USE Tienda;

CREATE TABLE productos (
  id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    precio DECIMAL(10,2),
    stock INT
);