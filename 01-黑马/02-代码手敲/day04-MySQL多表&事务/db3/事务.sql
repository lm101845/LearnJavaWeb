CREATE TABLE account ( id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR ( 10 ), balance DOUBLE );-- 添加数据
INSERT INTO account ( NAME, balance )
VALUES
	( 'zhangsan', 1000 ),
	( 'lisi', 1000 );
	
	
		SELECT * FROM account;
		
		SELECT @@autocommit;  -- 1代表自动提交，0代表手动提交
		
		-- 修改默认提交方式： 
		set @@autocommit = 1;
		
		UPDATE account SET balance = 1000;
		-- 张三给李四转账 500 元
		
		-- 0. 开启事务
		START TRANSACTION;
		
		-- 1. 张三账户 -500
		
		UPDATE account SET balance = balance - 500 WHERE NAME = 'zhangsan';
		-- 2. 李四账户 +500
		-- 出错了...
		UPDATE account SET balance = balance + 500 WHERE NAME = 'lisi';
		
		-- 发现执行没有问题，提交事务
		COMMIT;
		 
		-- 发现出问题了，回滚事务
		ROLLBACK;

-- 数据库查询隔离级别：
select @@tx_isolation;