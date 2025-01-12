-- USE `student_tracker`;-- 

-- SELECT * FROM student

-- DROP TABLE student-- 
-- ALTER TABLE student_tracker.student AUTO_INCREMENT=1000-- 

 -- reset AUto_increment starting with 1
-- TRUNCATE student_tracker.student


-- USE `student_tracker`


-- CREATE DATABASE IF NOT EXISTS `employee_directory`;

-- USE `employee_directory`;

-- DROP TABLE IF EXISTS `employee`;

-- CREATE TABLE `employee` (
-- 	`id` INT NOT NULL AUTO_INCREMENT,
--     `first_name` VARCHAR(45) NOT NULL,
--     `last_name` VARCHAR(45) NOT NULL,
--     `email` VARCHAR(45) NOT NULL,
--     PRIMARY KEY (`id`)
-- ) ENGINE = InnoDB auto_increment=1 DEFAULT CHARSET=latin1;

-- ENGINE = InnoDB auto_increment=1 DEFAULT CHARSET=latin1;
-- Giải thích từng phần:
-- 1. ENGINE = InnoDB
-- InnoDB là một storage engine (cơ chế lưu trữ) trong MySQL.
-- Tính năng chính của InnoDB:
-- Hỗ trợ giao dịch (Transactions): Các thao tác như COMMIT, ROLLBACK được hỗ trợ.
-- Khóa cấp hàng (Row-level locking): Hỗ trợ thao tác đồng thời với hiệu suất tốt hơn.
-- Ràng buộc khóa ngoại (Foreign Key Constraints): Đảm bảo tính toàn vẹn dữ liệu.
-- Khả năng chịu lỗi cao: Sử dụng crash recovery để khôi phục dữ liệu sau sự cố.
-- 2. auto_increment=1
-- Đặt giá trị khởi điểm cho cột có thuộc tính AUTO_INCREMENT.
-- Cụ thể trong bảng này:
-- Cột id là cột AUTO_INCREMENT, vì vậy giá trị tự động tăng bắt đầu từ 1 (do auto_increment=1).
-- Mỗi khi có một bản ghi mới được chèn vào bảng, giá trị của cột id sẽ tự động tăng lên (ví dụ: 1, 2, 3,...).
-- Lưu ý:

-- Nếu không chỉ định, giá trị mặc định của auto_increment sẽ là 1.
-- 3. DEFAULT CHARSET=latin1
-- CHARSET (Character Set) là bộ ký tự mặc định được sử dụng để lưu trữ dữ liệu dạng văn bản.
-- latin1 (ISO-8859-1) là một bộ ký tự:
-- Chỉ hỗ trợ ký tự 1 byte (tức là không hỗ trợ các ngôn ngữ có ký tự phức tạp như tiếng Trung, tiếng Việt có dấu đầy đủ).
-- Thường được sử dụng trong các ứng dụng chỉ hỗ trợ tiếng Anh hoặc các ngôn ngữ Tây Âu.
-- Lưu ý:

-- Đối với các ứng dụng hiện đại, bạn nên sử dụng utf8mb4 thay cho latin1, vì:
-- utf8mb4 hỗ trợ các ký tự phức tạp, bao gồm tiếng Việt và biểu tượng cảm xúc (emoji).
-- Ví dụ:
-- sql
-- Copy code
-- DEFAULT CHARSET=utf8mb4;
-- Tóm tắt
-- ENGINE = InnoDB: Sử dụng cơ chế lưu trữ InnoDB cho bảng.
-- auto_increment=1: Bắt đầu giá trị tự động tăng từ 1.
-- DEFAULT CHARSET=latin1: Sử dụng bộ ký tự Latin1 để lưu trữ dữ liệu văn bản (không phù hợp với dữ liệu tiếng Việt).

-- INSERT INTO `employee` VALUES
-- (1, 'Leslie', 'Andrews', 'leslie@luv2code.com'),
-- (2, 'Emma', 'Baumgarten', 'emma@luv2code.com'),
-- (3, 'Avani', 'Gupta', 'avani@luv2code.com'),
-- (4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
-- (5, 'Juan', 'Vega', 'juan@luv2code.com');


-- SELECT * FROM employee;



-- USE `employee_directory`;

-- DROP TABLE IF EXISTS `authorities`;
-- DROP TABLE IF EXISTS `users`;



-- CREATE TABLE `users` (
-- 	`username` VARCHAR(50) NOT NULL,
--     `password` CHAR(68) NOT NULL,
--     `enable` TINYINT NOT NULL,
--     PRIMARY KEY (`username`)
-- ) ENGINE = InnoDB DEFAULT CHARSET=latin1;


-- INSERT INTO `users` 
-- VALUES 
-- ('john', '{bcrypt}$2a$10$U08KuwslGaJhtoM38pnCm.nX7f/UrBOoaOQmGHvqZZFyVjFnWz4Am', 1),
-- ('mary', '{bcrypt}$2a$10$U08KuwslGaJhtoM38pnCm.nX7f/UrBOoaOQmGHvqZZFyVjFnWz4Am', 1),
-- ('susan', '{bcrypt}$2a$10$U08KuwslGaJhtoM38pnCm.nX7f/UrBOoaOQmGHvqZZFyVjFnWz4Am', 1);



-- CREATE TABLE `authorities` (
-- 	`username` VARCHAR(50) NOT NULL,
--     `authority` VARCHAR(50) NOT NULL,
--     UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
--     CONSTRAINT `authorities_idx_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
-- ) ENGINE = InnoDB DEFAULT CHARSET=latin1;




-- INSERT INTO `authorities` 
-- VALUES 
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_MANAGER'),
-- ('susan','ROLE_ADMIN');

--  SELECT * FROM authorities;
-- SELECT * FROM users;-- 


-- UPDATE `employee_directory`.`users` SET `password` = '{noop}test123' WHERE `username` = 'susan';
-- SELECT * FROM users;






-- USE `employee_directory`;

-- DROP TABLE IF EXISTS `roles`;
-- DROP TABLE IF EXISTS `members`;

-- CREATE TABLE `members` (
-- 	`user_id` varchar(50) NOT NULL,
--     `pw` char(68) NOT NULL,
--     `active` tinyint NOT NULL,
--     PRIMARY KEY (`user_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- INSERT INTO `members`
-- VALUES
-- ('john','{bcrypt}$2a$10$RlEAbaVgIndLHJKzb7moTuaA.XKjywJYX1ZwW/MWcUXiNxmpP0vq2',1),
-- ('mary','{bcrypt}$2a$10$RlEAbaVgIndLHJKzb7moTuaA.XKjywJYX1ZwW/MWcUXiNxmpP0vq2',1),
-- ('susan','{bcrypt}$2a$10$RlEAbaVgIndLHJKzb7moTuaA.XKjywJYX1ZwW/MWcUXiNxmpP0vq2',1);


-- CREATE TABLE `roles` (
--   `user_id` varchar(50) NOT NULL,
--   `role` varchar(50) NOT NULL,
--   UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
--   CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;





-- INSERT INTO `roles`
-- VALUES
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_MANAGER'),
-- ('susan','ROLE_ADMIN');



-- USE `employee_directory`;

-- SET foreign_key_checks = 0;
-- DROP TABLE IF EXISTS `user`;
-- DROP TABLE IF EXISTS `role`;
-- SET foreign_key_checks = 1;

-- --
-- -- Table structure for table `user`
-- --

-- DROP TABLE IF EXISTS `user`;

-- CREATE TABLE `user` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `username` varchar(50) NOT NULL,
--   `password` char(80) NOT NULL,
--   `enabled` tinyint NOT NULL,  
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

-- INSERT INTO `user` (`username`,`password`,`enabled`)
-- VALUES 
-- ('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);


-- --
-- Table structure for table `role`
--

-- DROP TABLE IF EXISTS `role`;

-- CREATE TABLE `role` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `name` varchar(50) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- --
-- -- Dumping data for table `roles`
-- --

-- INSERT INTO `role` (name)
-- VALUES 
-- ('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');

-- --
-- -- Table structure for table `users_roles`
-- --

-- DROP TABLE IF EXISTS `users_roles`;

-- CREATE TABLE `users_roles` (
--   `user_id` int(11) NOT NULL,
--   `role_id` int(11) NOT NULL,
--   
--   PRIMARY KEY (`user_id`,`role_id`),
--   
--   KEY `FK_ROLE_idx` (`role_id`),
--   
--   CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
--   REFERENCES `user` (`id`) 
--   ON DELETE NO ACTION ON UPDATE NO ACTION,
--   
--   CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
--   REFERENCES `role` (`id`) 
--   ON DELETE NO ACTION ON UPDATE NO ACTION
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- SET FOREIGN_KEY_CHECKS = 1;

-- --
-- -- Dumping data for table `users_roles`
-- --

-- INSERT INTO `users_roles` (user_id,role_id)
-- VALUES 
-- (1, 1),
-- (2, 1),
-- (2, 2),
-- (3, 1),
-- (3, 2),
-- (3, 3)






-- CREATE DATABASE  IF NOT EXISTS `employee_directory`;
-- USE `employee_directory`;

-- --
-- -- Table structure for table `employee`
-- --

-- DROP TABLE IF EXISTS `employee`;

-- CREATE TABLE `employee` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(45) DEFAULT NULL,
--   `last_name` varchar(45) DEFAULT NULL,
--   `email` varchar(45) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

-- INSERT INTO `employee` VALUES 
-- 	(1,'Leslie','Andrews','leslie@luv2code.com'),
-- 	(2,'Emma','Baumgarten','emma@luv2code.com'),
-- 	(3,'Avani','Gupta','avani@luv2code.com'),
-- 	(4,'Yuri','Petrov','yuri@luv2code.com'),
-- 	(5,'Juan','Vega','juan@luv2code.com');
-- CREATE DATABASE  IF NOT EXISTS `employee_directory`;
-- USE `employee_directory`;

-- --
-- -- Table structure for table `employee`
-- --

-- DROP TABLE IF EXISTS `employee`;

-- CREATE TABLE `employee` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(45) DEFAULT NULL,
--   `last_name` varchar(45) DEFAULT NULL,
--   `email` varchar(45) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- --
-- -- Data for table `employee`
-- --

-- INSERT INTO `employee` VALUES 
-- 	(1,'Leslie','Andrews','leslie@luv2code.com'),
-- 	(2,'Emma','Baumgarten','emma@luv2code.com'),
-- 	(3,'Avani','Gupta','avani@luv2code.com'),
-- 	(4,'Yuri','Petrov','yuri@luv2code.com'),
-- 	(5,'Juan','Vega','juan@luv2code.com');






-- USE `employee_directory`;

-- DROP TABLE IF EXISTS `authorities`;
-- DROP TABLE IF EXISTS `users`;

-- --
-- -- Table structure for table `users`
-- --

-- CREATE TABLE `users` (
--   `username` varchar(50) NOT NULL,
--   `password` char(68) NOT NULL,
--   `enabled` tinyint NOT NULL,
--   PRIMARY KEY (`username`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --
-- -- Inserting data for table `users`
-- --

-- INSERT INTO `users` 
-- VALUES 
-- ('john','{bcrypt}$2a$10$agJtR3VGCriM6X8.2DVUyeeRDthspopVi6MBYFEVas4Amr7L83/G.',1),
-- ('mary','{bcrypt}$2a$10$agJtR3VGCriM6X8.2DVUyeeRDthspopVi6MBYFEVas4Amr7L83/G.',1),
-- ('susan','{bcrypt}$2a$10$agJtR3VGCriM6X8.2DVUyeeRDthspopVi6MBYFEVas4Amr7L83/G.',1);


-- --
-- -- Table structure for table `authorities`
-- --

-- CREATE TABLE `authorities` (
--   `username` varchar(50) NOT NULL,
--   `authority` varchar(50) NOT NULL,
--   UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
--   CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --
-- -- Inserting data for table `authorities`
-- --

-- INSERT INTO `authorities` 
-- VALUES 
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_MANAGER'),
-- ('susan','ROLE_ADMIN');





-- USE `employee_directory`;

-- DROP TABLE IF EXISTS `roles`;
-- DROP TABLE IF EXISTS `members`;

-- --
-- -- Table structure for table `members`
-- --

-- CREATE TABLE `members` (
--   `user_id` varchar(50) NOT NULL,
--   `pw` char(68) NOT NULL,
--   `active` tinyint NOT NULL,
--   PRIMARY KEY (`user_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --
-- -- Inserting data for table `members`
-- --
-- -- NOTE: The passwords are encrypted using BCrypt
-- --
-- -- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
-- --
-- -- Default passwords here are: fun123
-- --

-- INSERT INTO `members`
-- VALUES
-- ('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
-- ('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
-- ('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


-- --
-- -- Table structure for table `authorities`
-- --

-- CREATE TABLE `roles` (
--   `user_id` varchar(50) NOT NULL,
--   `role` varchar(50) NOT NULL,
--   UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
--   CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --
-- -- Inserting data for table `roles`
-- --

-- INSERT INTO `roles`
-- VALUES
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_MANAGER'),
-- ('susan','ROLE_ADMIN');










-- DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;

-- CREATE SCHEMA `hb-01-one-to-one-uni`;

-- use `hb-01-one-to-one-uni`;

-- SET FOREIGN_KEY_CHECKS = 0;

-- CREATE TABLE `instructor_detail` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `youtube_channel` varchar(128) DEFAULT NULL,
--   `hobby` varchar(45) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- CREATE TABLE `instructor` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(45) DEFAULT NULL,
--   `last_name` varchar(45) DEFAULT NULL,
--   `email` varchar(45) DEFAULT NULL,
--   `instructor_detail_id` int DEFAULT NULL UNIQUE,
--   PRIMARY KEY (`id`),
--   CONSTRAINT `FK_DETAIL`
--     FOREIGN KEY (`instructor_detail_id`) 
--     REFERENCES `instructor_detail` (`id`) 
--     ON DELETE CASCADE 
--     ON UPDATE CASCADE
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- SET FOREIGN_KEY_CHECKS = 1;



















DROP SCHEMA IF EXISTS `hb-03-one-to-many`;

CREATE SCHEMA `hb-03-one-to-many`;

use `hb-03-one-to-many`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) 
  REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
