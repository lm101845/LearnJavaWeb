	create table student4(
			id int primary key auto_increment,-- 给id添加主键约束
			name varchar(20)
		);
		
		SELECT * FROM student4;
		
		INSERT INTO student4 VALUES(NULL,'ccDc');
		
		INSERT INTO student4 VALUES(14,'cccD');
		
		-- 删除自动增长
		ALTER TABLE student4 MODIFY id INT;
		
		-- 添加自动增长
		ALTER TABLE student4 MODIFY id INT AUTO _INCREMENT;