-- 创建旅游线路分类表 tab_category
-- cid 旅游线路分类主键，自动增长
-- cname 旅游线路分类名称非空，唯一，字符串 100
create table tab_category (
cid int primary key auto_increment,
cname varchar(100) not null unique
)

-- 添加旅游线路分类数据：
insert into tab_category (cname) values ('周边游'), ('出境游'), ('国内游'), ('港澳游');
select * from tab_category;
-- 创建旅游线路表 tab_route
/*
rid 旅游线路主键，自动增长
rname 旅游线路名称非空，唯一，字符串 100
price 价格
rdate 上架时间，日期类型
cid 外键，所属分类
*/
create table tab_route(
rid int primary key auto_increment,
rname varchar(100) not null unique,
price double,
rdate date,
cid int,
foreign key (cid) references tab_category(cid)
)

-- 添加旅游线路数据
INSERT INTO tab_route VALUES
(NULL, '【厦门+鼓浪屿+南普陀寺+曾厝垵 高铁 3 天 惠贵团】尝味友鸭面线 住 1 晚鼓浪屿', 1499,
'2018-01-27', 1),
(NULL, '【浪漫桂林 阳朔西街高铁 3 天纯玩 高级团】城徽象鼻山 兴坪漓江 西山公园', 699, '2018-02-
22', 3),
(NULL, '【爆款￥1699 秒杀】泰国 曼谷 芭堤雅 金沙岛 杜拉拉水上市场 双飞六天【含送签费 泰风情 广州
往返 特价团】', 1699, '2018-01-27', 2),(NULL, '【经典•狮航 ￥2399 秒杀】巴厘岛双飞五天 抵玩【广州往返 特价团】', 2399, '2017-12-23',
2),
(NULL, '香港迪士尼乐园自由行 2 天【永东跨境巴士广东至迪士尼去程交通+迪士尼一日门票+香港如心海景酒店
暨会议中心标准房 1 晚住宿】', 799, '2018-04-10', 4);
select * from tab_route;

/*
创建用户表 tab_user
uid 用户主键，自增长
username 用户名长度 100，唯一，非空
password 密码长度 30，非空
name 真实姓名长度 100
birthday 生日
sex 性别，定长字符串 1
telephone 手机号，字符串 11
email 邮箱，字符串长度 100
*/
create table tab_user (
		uid int primary key auto_increment,
		username varchar(100) unique not null,
		password varchar(30) not null,
		name varchar(100),
		birthday date,
		sex char(4) default 'man',
		telephone varchar(11),
		email varchar(100)
)
-- 添加用户数据
INSERT INTO tab_user VALUES
(NULL, 'cz110', 123456, '老王', '1977-07-07', '男', '13888888888', '66666@qq.com'),
(NULL, 'cz119', 654321, '小王', '1999-09-09', '男', '13999999999', '99999@qq.com');
select * from tab_user;
/*
创建收藏表 tab_favorite
rid 旅游线路 id，外键
date 收藏时间
uid 用户 id，外键
rid 和 uid 不能重复，设置复合主键，同一个用户不能收藏同一个线路两次
*/
create table tab_favorite (
rid int,
date datetime,
uid int,
-- 创建复合主键
primary key(rid,uid),
foreign key (rid) references tab_route(rid),
foreign key(uid) references tab_user(uid)
)
-- 增加收藏表数据
INSERT INTO tab_favorite VALUES

(1, '2018-01-01', 1), -- 老王选择厦门
(2, '2018-02-11', 1), -- 老王选择桂林
(3, '2018-03-21', 1), -- 老王选择泰国
(2, '2018-04-21', 2), -- 小王选择桂林
(3, '2018-05-08', 2), -- 小王选择泰国
(5, '2018-06-02', 2); -- 小王选择迪士尼
select * from tab_favorite;