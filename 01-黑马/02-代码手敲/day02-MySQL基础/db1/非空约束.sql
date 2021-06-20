-- 方式1：创建表添加非空约束
create table student2(
	id int,
	name varchar(20) not null  -- name为非空约束
);

SELECT * from student2;

-- 删除name的非空约束
alter table student2 MODIFY name VARCHAR(20);

-- 方式2：创建表完后添加非空约束
ALTER TABLE student2 MODIFY NAME VARCHAR(20) NOT NULL;
SELECT * FROM student2;

drop table student2;

-- 在创建表时添加唯一约束
CREATE TABLE student2(
		id INT,
		phone_number VARCHAR(20) UNIQUE  -- 手机号不能重复，添加唯一约束
);

SELECT * FROM student2;

-- 删除唯一约束
ALTER TABLE student2 MODIFY phone_number VARCHAR(20);

ALTER TABLE student2 DROP INDEX phone_number;

-- 在表创建完后添加唯一约束
ALTER TABLE student2 MODIFY phone_number VARCHAR(20) UNIQUE;

