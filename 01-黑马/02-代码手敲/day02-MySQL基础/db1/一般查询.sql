--  查询年龄大于或等于20岁
 select * from student where age >= 20;
 
 select * from student where age < 20;
	
	
select * from student where age <> 57;

-- 查询年龄20-30岁之间的人
SELECT * from student where age >= 20 && age <=30;
SELECT * from student where age >= 20 and age <=30;

select * from student where age BETWEEN 20 and 30;

-- 查询年龄22岁，18岁，25岁的信息
select * from student WHERE age = 22 or age = 18 or age = 25;

select * from student WHERE age in (22,18,55);

-- 查询英语缺考的人
-- SELECT * from student where english = null;  -- 语句不正确，null值不能使用= 或<>来判断
SELECT * from student where english is null;
SELECT * from student where english is not null;
