CREATE DATABASE `javaPoz15Warehouse`;

USE `javaPoz15Warehouse`;

CREATE TABLE `tools` (
                       `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `name` VARCHAR(50) NOT NULL,
                       `type` VARCHAR(50) NOT NULL,
                       `available` BOOLEAN NOT NULL
);

CREATE TABLE `users` (
                       `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `login` VARCHAR(50) NOT NULL UNIQUE,
                       `password` VARCHAR(250) NOT NULL
);

insert into `users` (`login`, `password`) values
('user1', 'user1'),
('user2', 'user2');

insert into `tools` (`name`, `type`, `available`) values
('Stara piła', 'SAW', 0),
('Czerwony młotek', 'HAMMER', 0);