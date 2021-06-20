-- 每页想显示3条记录

select * from student limit 0,3;  -- 从0开始查，查3条记录  --第一页

SELECT * from student LIMIT 3,3;  -- 第二页

-- 公式：开始的索引 = (当前的页码-1)*每页显示的条数

SELECT * from student LIMIT 6,3;  -- 第三页