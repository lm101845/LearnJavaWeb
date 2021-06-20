SELECT * FROM dept;

SELECT * FROM emp;

-- 新入职员工，但是他刚来时没有任何部门(虽然时外键，但是我们这个外键并没有给它加非空约束)
-- 查询所有员工信息，如果员工有部门，则查询部门名称，没有部门，则不显示部门名称

SELECT 
	t1.*,t2.`NAME`
FROM 

		emp t1,dept t2
		
WHERE
	  t1.`dept_id` = t2.`id`;
		
-- 这是一个分割线		

SELECT 
	t1.*,t2.`NAME`
FROM 

		emp t1 LEFT JOIN dept t2
		
ON
	  t1.`dept_id` = t2.`id`;
		
-- 这是一个分割线		
SELECT 
	t1.*,t2.`NAME`
FROM 

		emp t1 RIGHT JOIN dept t2
		
ON
	  t1.`dept_id` = t2.`id`;
		
-- 这是一个分割线		
SELECT 
	*
FROM 

	dept t2 RIGHT JOIN emp t1
		
ON
	  t1.`dept_id` = t2.`id`;