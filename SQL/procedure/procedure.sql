-- 这个存储过程的作用是：输入一个学号，
-- 计算小于这个学号的学生的平均成绩


-- 定义换行符
delimiter //

DROP PROCEDURE IF EXISTS sp_getave;
-- 创建存储过程sp_getave,
-- 有两个参数，分别是一个输入参数，一个输出参数
CREATE PROCEDURE sp_getave(IN input INT, OUT output INT)
-- 存储过程开始
BEGIN
-- 存储过程内容
	SELECT 
		@sum := @sum + value
	FROM student s, (SELECT @sum := 0) v
	WHERE s.id < input;
	SET output := @sum / (input - 1);
-- 存储过程结束，注意：END后需要加上换行符标志，即，最开始定义的
END //

-- 将换行符换回来
delimiter ;

-- 执行
CALL sp_getave(4,@output);
-- 查看输出结果
SELECT @output;