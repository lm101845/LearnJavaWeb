SELECT * from student ORDER BY math  -- 排序方式，不写默认升序

SELECT * from student ORDER BY math  DESC-- 排序方式

-- 按照数学成绩排名，如果数学成绩一样，则按照英语成绩片排名

SELECT * from student ORDER BY math ASC,english desc;  -- 每一个排序条件都可以指定不同的排序方式

-- 计算班级里面有多少人
SELECT count(name) from student;

SELECT * from student;

SELECT count(english) from student;

SELECT count(ifnull(english,0)) from student;

SELECT count(*) from student;  -- 只要这一列数据有一个不为Null,它就能算，但是公司中不推荐

select max(math) from student;

select min(math) from student;

select sum(english) from student;

select avg(math) from student;

