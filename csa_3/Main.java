package csa_3;

import java.util.*;
public class Main {
    public static void main(String[] args){
        System.out.println("第一题");
        Monkey monkeyA = new Monkey("A");
        People peopleB = new People("B");
        monkeyA.speak();
        peopleB.speak();
        peopleB.think();
        System.out.println("第二题");
        Car carA = new Car(6,4,1150.0);
        Truck truckB = new Truck(3,6,15000.0,5000);
        carA.loading(3);
        truckB.loading(1,3000.0);
        carA.loading(7);
        truckB.loading(4,7000.0);
        System.out.println("第三题");
        String a = "88888888888888888";
        String b = "25461213124533465";
        System.out.println(a + "+" + b + "=" + getSum(a,b));
        System.out.println("第四题");
        System.out.println(uniquePaths(7,3));
        System.out.println("第五题");
        String []strs1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs1));
        String []strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2));
    }
    //超大数求和
    public static String getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        //用于进位
        int carry = 0;
        //保证 la 的长度大于 lb
        if(a.length()<b.length()){
            c = a;
            a = b;
            b = c;
        }
        for(int i = a.length()-1;i >= 0;--i){
            la.add(a.charAt(i)-'0');
        }
        for(int i = b.length()-1;i >= 0;--i){
            lb.add(b.charAt(i)-'0');
        }
        //将 lb 的长度补足到与 la 相等 （如本来就相等，也会补一位，但不影响）
        for (int i = a.length()-b.length();i>0;--i){
            lb.add(0);
        }
        //将每一位相加，赋给 la ,如大于十，进位
        for (int i = 0;i<a.length();i++){
            int j = la.get(i) + lb.get(i) + carry;
            if(j<10){
                la.set(i,j);
                carry = 0;
            }else {
                la.set(i,j-10);
                carry = 1;
            }
        }
        //如最高位进位， la 补一位
        if(carry == 1){
            la.add(1);
        }
        //la 转为字符串 c
        Stack stack = new Stack();
        for (int i : la){
            stack.push(i);
        }
        for (int i : la){
            c += stack.pop();
        }
        return c;
    }
    public static int uniquePaths(int m, int n) {
        int [][] form = new int[m][n];
        //最上一行，最左一列，只有一种走法
        for (int i = 0;i < m;i++){
            form[i][0] = 1;
        }
        for (int i = 0;i < n;i++){
            form[0][i] = 1;
        }
        //每一格走法为：其左一格走法 + 其上一格走法
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                form[i][j] = form[i-1][j] + form[i][j-1];
            }
        }
        return form[m-1][n-1];
    }
    /*
    第五题
    编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 “”。
     */
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        //获取最短字符串
        String shortestStr = strs[0];
        for (String i : strs){
            if (shortestStr.length() > i.length()){
                shortestStr = i;
            }
        }
        int a =0;
        while (a < shortestStr.length()){
            boolean b = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(a) != strs[i - 1].charAt(a)) {
                    b = false;
                    break;
                }
            }
            if (b){
                ans += strs[0].charAt(a);
                a++;
            }else {
                break;
            }
        }
        if (a == 0){
            System.out.println("输入不存在公共前缀。");
        }
        return ans;
    }
}