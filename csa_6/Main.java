package csa_6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("JDBC作业：");
/*
建表在 MySQL 中进行：
create database if not exists csa_java_mysql character set utf8;
use csa_java_mysql;
create table student (
	SNO varchar(20),
	Name varchar(10),
	age integer,
	College varchar(30)
);
 */
        System.out.println(
            "----------------------\n" +
            "第一题效果\n" +
            "----------------------");
        new JDBC().set("insert into student values " +
            "('s001','老大',20,'计算机学院'), " +
            "('s002','老二',19,'计算机学院'), " +
            "('s003','老三',18,'计算机学院'), " +
            "('s004','老四',17,'计算机学院');");
        new JDBC().getAll();
        System.out.println(
            "----------------------\n" +
            "第二题效果\n" +
            "----------------------");
        new JDBC().get("select * from student;");
        System.out.println(
            "----------------------\n" +
            "第三题效果\n" +
            "----------------------");
        new JDBC().set("delete from student where SNO = 's004';");
        new JDBC().getAll();
        System.out.println(
            "----------------------\n" +
            "第四题效果\n" +
            "----------------------");
        new JDBC().get("select * from student where SNO = 's003';");
        System.out.println(
            "----------------------\n" +
            "第五题效果\n" +
            "----------------------");
        new JDBC().set("update student set College='通信学院' where SNO='s001';");
        new JDBC().getAll();
/*
以上内容转化为 mysql 语句为：
insert into student values
	('s001','老大',20,'计算机学院'),
	('s002','老二',19,'计算机学院'),
	('s003','老三',18,'计算机学院'),
	('s004','老四',17,'计算机学院'); -- 第1题
select * from student; -- 第2题
delete from student where SNO = 's004'; -- 第3题
select * from student where SNO = 's003'; -- 第4题
update student set College='通信学院' where SNO='s001'; -- 第5题
 */
        System.out.println("排序作业：");
        Sort sort = new Sort();
        for (int i = 0;i < 5;i++) {
            int[] arr = new int[]{10,100,5,17,1,4,3,9,7,11};
            System.out.println(Arrays.toString(sort.useMethod(i, arr)));
        }
    }
}
