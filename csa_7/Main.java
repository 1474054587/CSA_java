import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("第一题：");
        System.out.println(Arrays.toString(one(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(one(new int[]{2,4},new int[]{1,2,3,4})));
        System.out.println("第二题");
        System.out.println(two(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(two(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
        System.out.println("第三题");
        System.out.println(three(new int[]{1,2,3,2}));
        System.out.println(three(new int[]{1,1,1,1,1}));
        System.out.println(three(new int[]{1,2,3,4,5}));
    }
    public static int[] one(int[] nums1,int[] nums2){
        int result[] = new int[nums1.length];
        Stack<Integer> stack = new Stack();
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty() || stack.peek()>nums2[i]){
                stack.push(nums2[i]);
            }else {
                while (nums2[i]>stack.peek()){
                    map.put(stack.peek(),nums2[i]);
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(nums2[i]);
            }
        }
        while (!stack.isEmpty()){
            map.put(stack.peek(),-1);
            stack.pop();
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    public static boolean two(int pushed[],int popped[]){
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(pushed[0]);
        for (int i = 1; i < pushed.length; i++) {
            if (stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
            stack.push(pushed[i]);
        }
        while (!stack.isEmpty()){
            if (stack.peek() == popped[index]){
                stack.pop();
                index++;
            }else {
                return false;
            }
        }
        return true;
    }
    public static int three(int nums[]){
        Hashtable hashtable = new Hashtable(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(nums[i])) {
                hashtable.put(nums[i],0);
            }else {
                hashtable.put(nums[i],nums[i]);
            }
        }
        Enumeration sum = hashtable.elements();
        int result = 0;
        while (sum.hasMoreElements()){
            result += (int) sum.nextElement();
        }
        return result;
    }
}
