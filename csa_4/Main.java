package csa_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("-----------第一题-----------");
        UseCompute com = new UseCompute();
        com.useCom(com.plus,30,10);
        com.useCom(com.minus,30,10);
        com.useCom(com.multiply,30,10);
        com.useCom(com.divide,30,10);
        com.useCom(com.divide,30,0);
        System.out.println("-----------第二题-----------");
        getScore();
        System.out.println("-----------第三题-----------");
        getAverage();
        System.out.println("-----------第四题-----------");
        Programmer jiege = new Programmer("杰哥",10086,new MyDate(2000,1,1)) {};
        System.out.println(jiege);
        jiege.earnings();
        jiege.earnings();
        System.out.println(jiege.getName() + "的薪水：" + jiege.getMoney());
        System.out.println("-----------第五题-----------");
        System.out.println(getSubsequence("abcde",new String[]{"a","bb","acd","ace"}));
        System.out.println("-----------OVER!-----------");
    }
    public static void getScore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数：");
        int score = sc.nextInt();
        try{
            if(score>100||score<0){
                throw new NumberException("分数必须在 0—100 之间");
            }else {
                System.out.println("成绩为："+score);
            }
        }catch (NumberException f){
            f.printStackTrace();
        }
    }
    public static void getAverage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("计算N个整数的平均值。\n请输入N的值：");
        int n;
        while (true){
            n = sc.nextInt();
            try {
                if(n < 0){
                    throw new NumberException("\nN 必须是正数或者 0\n请再次输入。");
                }else {
                    break;
                }
            }catch (NumberException g){
                g.printStackTrace();
            }
        }
        int number = 0;
        if(n > 0){
            System.out.println("请输入" + n + "个整数：");
            for (int i = 0;i < n;i++){
                System.out.println("第" + (i+1) + "个：");
                number += sc.nextInt();
            }
            number = number / n;
        }
        System.out.println("这" + n + "个整数的平均值为：" + number);
    }
    public static int getSubsequence(String s,String[] words){
        int result = 0;
        for (String i : words){
            int index = 0;
            for (int j = 0;j < s.length();j++){
                if (s.charAt(j) == i.charAt(index)){
                    index++;
                }
                if (index == i.length()){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}