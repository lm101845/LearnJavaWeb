SELECT * from student;

-- 按照性别分组，分别查询男、女同学的平均分
select sex ,avg(math)from student GROUP BY sex;

-- 按照性别分组，分别查询男、女同学的平均分，人数
SELECT sex ,avg(math),count(id) from student GROUP BY sex;

SELECT name, sex ,avg(math),count(id) from student GROUP BY sex;  -- 这个name没有意义

-- 按照性别分组，分别查询男、女同学的平均分，人数 要求：分数低于70分的人，不参与分组
SELECT sex ,avg(math),count(id) from student WHERE math > 70 GROUP BY sex;

-- 按照性别分组，分别查询男、女同学的平均分，人数 要求：分数低于70分的人，不参与分组,分组之后，人数要大于2个人
SELECT sex ,avg(math),count(id) from student WHERE math > 70 GROUP BY sex HAVING count(id) > 2; 

SELECT sex ,avg(math),count(id) totalpeople from student WHERE math > 70 GROUP BY sex HAVING totalpeople > 2; 

