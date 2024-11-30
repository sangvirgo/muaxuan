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



USE `employee_directory`;

-- DROP TABLE IF EXISTS `authorities`;
-- DROP TABLE IF EXISTS `users`;



-- CREATE TABLE `users` (
-- 	`username` VARCHAR(50) NOT NULL,
--     `password` VARCHAR(50) NOT NULL,
--     `enable` TINYINT NOT NULL,
--     PRIMARY KEY (`username`)
-- ) ENGINE = InnoDB DEFAULT CHARSET=latin1;


-- INSERT INTO `users` 
-- VALUES 
-- ('john', '{noop}test123', 1),
-- ('mary', '{noop}test123', 1),
-- ('susan', '{noop}test123', 1);



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


UPDATE `employee_directory`.`users` SET `password` = '{noop}test123' WHERE `username` = 'susan';
SELECT * FROM users;