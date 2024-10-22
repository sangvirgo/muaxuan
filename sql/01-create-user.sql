-- Drop user first if they exist
DROP USER if exists 'springstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'springstudent'@'%' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';



-- REVOKE SELECT, INSERT ON mydatabase.* FROM 'readonlyuser'@'localhost';
--  remove grant

-- GRANT privileges ON database_name.table_name TO 'user_name'@'host' IDENTIFIED BY 'password';
-- privileges: Là quyền mà bạn muốn cấp cho người dùng, ví dụ như SELECT, INSERT, UPDATE, DELETE, ALL PRIVILEGES,...
-- database_name: Tên của cơ sở dữ liệu mà bạn muốn cấp quyền.
-- table_name: Tên của bảng trong cơ sở dữ liệu. Nếu bạn muốn cấp quyền trên toàn bộ cơ sở dữ liệu, dùng dấu *.
-- user_name: Tên người dùng mà bạn muốn cấp quyền.
-- host: Xác định máy chủ mà từ đó người dùng có thể truy cập vào MySQL. Ví dụ: 'localhost' hoặc '% (tất cả các địa chỉ IP).
-- password: Mật khẩu của người dùng (có thể chỉ định trong câu lệnh IDENTIFIED BY).