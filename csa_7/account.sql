USE csa_java_mysql;
CREATE TABLE `account` (
	`id` VARCHAR(255) NOT NULL PRIMARY KEY, -- id
	`name` VARCHAR(255) DEFAULT NULL, -- 用户名
	`money` INT(255) DEFAULT NULL, -- 账户余额
	`createtime` DATE DEFAULT NULL, -- 开户时间
	`updatetime` DATE DEFAULT NULL -- 更新时间
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES ('1','aa',10,'2021-12-17','2021-12-17');