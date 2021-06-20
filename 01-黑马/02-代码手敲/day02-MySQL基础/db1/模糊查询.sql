-- 查询班级中姓马的人有哪些
SELECT * from student where name like '马%';

-- 查询姓名第二个字是化的人
select * from student where name like '_化%';

-- 查询姓名是3个字的人
SELECT * from student where name like '___';

-- 查询姓名中包含马的人
select * from student where name like '%马%';