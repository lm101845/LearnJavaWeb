-- DQL：查询表中的记录
-- 语法：
-- 	select
-- 		字段列表
-- 	from
-- 		表名列表
-- 	where
-- 		条件列表
-- 	group by
-- 		分组字段
-- 	having
-- 		分组之后的条件
-- 	order by
-- 		排序
-- 	limit
-- 		分页限定
CREATE TABLE student (
	id INT,-- 编号
	NAME VARCHAR ( 20 ),-- 姓名
	age INT,-- 年龄
	sex VARCHAR ( 5 ),-- 性别
	address VARCHAR ( 100 ),-- 地址
	math INT,-- 数学
	english INT -- 英语
	
);
INSERT INTO student ( id, NAME, age, sex, address, math, english )
VALUES
	( 1, '马云', 55, '男', '
		杭州', 66, 78 ),(
		2,
		'马化腾',
		45,
		'女',
		'深圳',
		98,
		87 
		),(
		3,
		'马景涛',
		55,
		'男',
		'香港',
		56,
		77 
		),(
		4,
		'柳岩
		',
		20,
		'女',
		'湖南',
		76,
		65 
		),(
		5,
		'柳青',
		20,
		'男',
		'湖南',
		86,
	NULL 
		),(
		6,
		'刘德华',
		57,
		'男',
		'香港',
		99,
		99 
		),(
		7,
		'马德',
		22,
		'女',
		'香港',
		99,
		99 
		),(
		8,
		'德玛西亚',
		18,
		'男',
		'南京',
		56,
		65 
	);
SELECT
	* 
FROM
	student;
DROP TABLE student;-- 查询姓名和年龄
SELECT NAME
	,-- 姓名
	age -- 年龄
	
FROM
	student;-- 学生表
SELECT
	address 
FROM
	student;-- 去除重复的结果集
SELECT DISTINCT
	address 
FROM
	student;-- 要去重必须保证两条记录的结果集完全一样才行
SELECT NAME
	,
	address 
FROM
	student;-- 计算math和english分数之和
-- 如果有null参与的计算，计算结果都为null
-- 但是这个不合理啊，我数学86，英文没考，但是最终还是null，应该是86
SELECT NAME
	,
	math,
	english,
	math + english 
FROM
	student;
SELECT NAME
	,
	math,
	english,
	math + IFNULL( english, 0 ) 
FROM
	student;
	
SELECT NAME
	,
	math,
	english,
	math + IFNULL( english, 0 ) AS zongfen 
FROM
	student;-- 不写as,后面有空格(一个或多个)也行
SELECT NAME
	,
	math,
	english,
	math + IFNULL( english, 0 ) totalscore 
FROM
	student;