-- 查询所有员工信息和对应的部门信息(dept_id和id一样才叫对应)


SELECT * FROM emp,dept where emp.`dept_id` = dept.`id`;

-- 查询员工表的名称，性别以及部门表的名称
SELECT emp.NAME,emp.gender,dept.NAME FROM emp,dept where emp.`dept_id` = dept.`id`;

SELECT 
	t1.name,		-- 员工表的姓名
	t1.gender,	-- 员工表的性别
	t2.name			-- 部门表的姓名
FROM 
	emp t1,dept t2
WHERE
			t1.`dept_id` = t2.`id`;
			
			
-- 显式内连接
SELECT * FROM emp INNER JOIN dept  ON emp.`dept_id` = dept.`id`;

SELECT * FROM emp JOIN dept  ON emp.`dept_id` = dept.`id`; -- INNER可以省略
