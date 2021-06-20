-- 1.切换到mysql数据库
USE mysql;
-- 2.查询uses表

SELECT * FROM users;

-- 创建用户
CREATE USER 'liming'@'localhost' IDENTIFIED BY '123456';

SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123456');

 

