CREATE TABLE emp (  -- 创建emp表
		id INT PRIMARY KEY AUTO_INCREMENT,
		NAME VARCHAR(30),
		age INT,
		dep_name VARCHAR(30),  -- 部门名称
		dep_location VARCHAR(30)  -- 部门地址
);
-- 添加数据
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('张三', 20, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('李四', 21, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('王五', 20, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('老王', 20, '销售部', '深圳');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('大王', 22, '销售部', '深圳');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('小王', 18, '销售部', '深圳');

SELECT* FROM emp;

-- 发现数据有冗余
-- 我们应该做一个表的拆分，一张表专门存放员工信息，一张表专门存放部门信息
-- 然后我们让这2张表进行关联一下就可以了

-- 解决方案：分成 2 张表
-- 创建部门表(id,dep_name,dep_location)
-- 一方，主表
create table department(
id int primary key auto_increment,
dep_name varchar(20),
dep_location varchar(20)
);
-- 创建员工表(id,name,age,dep_id)
-- 多方，从表
create table employee(
id int primary key auto_increment,
name varchar(20),
age int,
dep_id int -- 外键对应主表的主键
)
-- 添加 2 个部门
insert into department values(null, '研发部','广州'),(null, '销售部', '深圳');
select * from department;

-- 添加员工,dep_id 表示员工所在的部门
INSERT INTO employee (NAME, age, dep_id) VALUES ('张三', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('李四', 21, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('王五', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('老王', 20, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('大王', 22, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('小王', 18, 2);
select * from employee;
