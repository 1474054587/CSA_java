package csa_8;

import java.util.HashMap;
import java.util.Random;

public class Week8 {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult:"+task3(new int[]
                    {0,4,5,6,8},target));
        }
    }
    public static void main(String[] args) {
        test();
    }
    public static boolean task1(String pattern, String str) {//第一题
        String s[] = str.split(" ");
        int n = pattern.length();
        if (n != s.length) {
            return false;
        }
        char p[] = new char[n];
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            p[i] = pattern.charAt(i);
            if (map.containsKey(p[i])) {
                if (!map.get(p[i]).equals(s[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(s[i])) {
                    return false;
                } else {
                    map.put(p[i],s[i]);
                }
            }
        }
        return true;
    }
    public static int task2(int[] nums) {//第二题
        int temp;
        for (int i = 0; i < nums.length-1; i++) {
            temp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    return temp;
                }
            }
        }
        return 0;
    }
    public static int task3(int []nums,int target){//第三题
        /*
        思考：Java内置的二分查找在找不到target的情况下为什么返回 -index-1
        因为正数和0代表找到，所以找不到只能返回负数，如果返回-index,则-0与0无法区分，只能再-1
         */
        int n = nums.length;
        if (target < nums[0]) {
            return -1;
        } else if (target > nums[n - 1]) {
            return -n - 1;
        }
        int low = 0;
        int high = n-1;
        int middle;
        while (true) {
            middle = (low + high) / 2;
            if (target < nums[middle]) {
                if (target > nums[middle-1]) {
                    return -middle-1;
                } else {
                    high = middle - 1;
                }
            } else if (target > nums[middle]) {
                if (target <nums[middle+1]) {
                    return -middle-2;
                } else {
                    low = middle + 1;
                }
            } else {
                return middle;
            }
        }
    }
}
