package csa_10;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Week10 {
    static Random random=new Random();
    public static void printArr(int[]nums){
        System.out.println(Arrays.toString(nums));
    }
    public static void test(){
        int[]nums1=new int[random.nextInt(20)+1];
        for(int i=0;i<nums1.length;i++)
            nums1[i]=random.nextInt(30)-10;
        printArr(nums1);
        printArr(task1(nums1));
        System.out.println("======================");
        int[]nums2=new int[random.nextInt(20)+1];
        for(int i=0;i<nums2.length;i++)
            nums2[i]=random.nextInt(3);
        printArr(nums2);
        task2(nums2);
        printArr(nums2);
    }
    public static void main(String[] args) {
        test();
    }
    public static int[] task1(int[]nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack(),stack1 = new Stack();
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
                temp = stack1.pop();
                res[temp] = i - temp;
            }
            stack.push(nums[i]);
            stack1.push(i);
        }
        return res;
    }
    public static void task2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums.length - i - 1; i1++) {
                if (nums[i1] > nums[i1+1]) {
                    temp = nums[i1];
                    nums[i1] = nums[i1+1];
                    nums[i1+1] = temp;
                }
            }
        }
    }
}
