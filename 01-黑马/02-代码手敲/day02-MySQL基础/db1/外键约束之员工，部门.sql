select * from department;

select * from employee;

DROP TABLE emp;

DROP TABLE department;

DROP TABLE employee;

-- 必须先创建部门表，再创建员工表，否则会报错
create table department(
id int primary key auto_increment,
dep_name varchar(20),
dep_location varchar(20)
);

create table employee(
		id int primary key auto_increment,
		name varchar(20),
		age int,
		dep_id int, -- 外键对应主表的主键
		CONSTRAINT emp_dept_fk FOREIGN KEY (dep_id) REFERENCES department(id)
);

-- 添加 2 个部门
insert into department values(null, '研发部','广州'),(null, '销售部', '深圳');


-- 添加员工,dep_id 表示员工所在的部门
INSERT INTO employee (NAME, age, dep_id) VALUES ('张三', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('李四', 21, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('王五', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('老王', 20, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('大王', 22, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('小王', 18, 2);
select * from employee;
select * from department;

-- 删除外键
ALTER TABLE employee DROP FOREIGN KEY emp_dept_fk;

-- 添加外键,设置级联更新
ALTER TABLE employee ADD CONSTRAINT emp_dept_fk FOREIGN KEY (dep_id) REFERENCES department(id) ON UPDATE CASCADE;

-- 设置级联删除
ALTER TABLE employee ADD CONSTRAINT emp_dept_fk FOREIGN KEY (dep_id) REFERENCES department(id) ON DELETE CASCADE;

-- 外键可以为NULL，但是不可以为不存在的外键值
UPDATE employee SET dep_id = NULL WHERE dep_id = 1;

UPDATE employee SET dep_id = 2 WHERE dep_id IS NULL;

