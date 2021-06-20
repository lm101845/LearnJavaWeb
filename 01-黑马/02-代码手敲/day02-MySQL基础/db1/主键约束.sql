CREATE TABLE student3(
	id INT PRIMARY KEY,  -- 给id添加主键约束
	NAME VARCHAR(20)
	-- 按住shift + tab可以缩进
);

-- 删除主键
-- 错误写法
-- ALTER TABLE student3 MODIFY id INT;   -- 虽然这个SQL语句执行成功了，但是它并不会生效

ALTER TABLE student3 DROP PRIMARY KEY;

-- 创建完表后，添加主键
ALTER TABLE student3 MODIFY id INT PRIMARY KEY;

SELECT * FROM student3;