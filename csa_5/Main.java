package csa_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("第一题");
        System.out.println(integerInversion(-231));
        System.out.println("第二题");
        System.out.println("有" + climbStairs(5) + "种方法爬到楼顶。");
        System.out.println("第三题");
        System.out.print("[ ");
        getAllSubset(new int[]{1,2,3},true);
        System.out.println("]");
    }
    //第一题
    public static int integerInversion(int n){
        String str;
        String str2;
        //判断正负
        if (n < 0) {
            str = "" + -n;
            str2 = "-";
        }else {
            str = "" + n;
            str2 = "";
        }
        Stack stack = new Stack();
        //进栈
        for (int i =0;i < str.length();i++){
            stack.push(str.substring(i,i+1));
        }
        //出栈
        for (int i =0;i < str.length();i++){
            str2 += stack.peek();
            stack.pop();
        }
        //String转long,检测长度
        if (Long.parseLong(str2) > Math.pow(2,31)-1 || Long.parseLong(str2) < -Math.pow(2,31)) {
            return 0;
        }else {
            return Integer.parseInt(str2);
        }
    }
    //爬到楼顶的方法数
    public static int climb;
    //第二题
    public static int climbStairs(int n){
        climb = 0;
        stairs(n);
        return climb;
    }
    //如果剩余楼梯数大于1，继续迭代，如果等于1或0，方法数加一，否则抛出异常
    public static void stairs(int n){
        try {
            if (n >= 2) {
                stairs(n-2);
                stairs(n-1);
            }else if (n == 1 || n == 0) {
                climb++;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("楼梯数应为自然数");
        }
    }
    //第三题
    public static List<Set<Integer>> getAllSubset(int[] n,boolean printOrNot){
        //数组转 HashSet 去重
        HashSet removeDuplicate = new HashSet();
        for (int i : n){
            removeDuplicate.add(i);
        }
        //HashSet 转 ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(removeDuplicate);
        //子集储存在 Set 集合中，返回值为包含所有 Set 集合的 List 集合
        ArrayList<Set<Integer>> result = new ArrayList<>();
        /*
        每一个 n 中的元素都分为取或不取
        因此包括空集和相等集，result 中应该有 2 的 n 次方个元素
        创建 2的n次方 个 Set集合，添加 1 至 2的n次方 的索引
        按照 偶/2，(奇+1)/2，的方法可以将索引转化为每个元素的取与不取，从而得到2的n次方个子集
        */
        for (int i = 1;i <= Math.pow(2,n.length);i++){
            Set<Integer> set = new HashSet<>();
            int j = i;
            int num = 0;
            while (num < n.length) {
                if (j % 2 == 0) {
                    j /= 2;
                    set.add(list.get(num));
                    num++;
                }else {
                    j = (j + 1) / 2;
                    num++;
                }
            }
            result.add(set);
        }
        //如果传入 true 则打印
        if (printOrNot) {
            for (Set<Integer> i : result){
                System.out.print(i + " ");
            }
        }
        return result;
    }
}