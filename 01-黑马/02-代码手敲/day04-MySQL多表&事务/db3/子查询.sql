-- 查询工资最高的员工信息

-- 1.查询最高的工资是多少 9000
SELECT MAX(salary) FROM emp;



-- 2.查询员工信息，并且工资等于9000的
SELECT * FROM emp WHERE emp.`salary` = 9000;	


-- 一条SQL就可以完成这个操作
SELECT * FROM emp WHERE emp.`salary` = (SELECT MAX(salary) FROM emp);


-- 查询员工工资小于平均工资的人
SELECT AVG(salary) FROM emp;
SELECT * FROM emp WHERE emp.salary < (SELECT AVG(salary) FROM emp);


-- 查询'财务部'和'市场部'所有的员工信息
SELECT id FROM dept WHERE NAME = '财务部' OR NAME = '市场部';
SELECT * FROM emp WHERE	dept_id = 3 OR dept_id = 2;

SELECT * FROM emp WHERE	dept_id IN(3,2);
-- 简化将OR写成IN

-- 子查询
SELECT * FROM emp WHERE	dept_id IN(SELECT id FROM dept WHERE NAME = '财务部' OR NAME = '市场部');

-- 	-- 查询员工入职日期是2011-11-11日之后的员工信息和部门信息
SELECT * FROM emp WHERE emp.`join_date` > '2011-11-11'; -- 虚拟表起别名叫t2

SELECT * FROM dept t1,(SELECT * FROM emp WHERE emp.`join_date` > '2011-11-11') t2 WHERE t1.id = t2.dept_id;

-- 普通内连接效果一样
SELECT * FROM emp t1,dept t2 WHERE t1.`dept_id` = t2.id AND t1.`join_date` > '2011-11-11';

