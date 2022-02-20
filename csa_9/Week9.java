package csa_9;

import java.util.*;

public class Week9 {
    public static void main(String[] args) {
        Week9 week9 = new Week9();
        System.out.println("第一题：");
        int nums[] = {5,3,6,1,12};
        int original = 3;
        System.out.println(week9.findFinalValue(nums,original));
        System.out.println("第二题");
        int nums2[] = {0,0,1,0};
        System.out.println(Arrays.toString(week9.maxScoreIndices(nums2).toArray()));
        System.out.println("第三题");
        System.out.println(week9.subStrHash("leetcode",7,20,2,0));
        System.out.println("第四题");
        System.out.println(Arrays.toString(week9.groupStrings(new String[]{"a", "b", "ab", "cde"})));
    }
    public int findFinalValue(int[] nums, int original) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == original) {
                original = original * 2;
                i = -1;
            }
        }
        return original;
    }
    public List<Integer> maxScoreIndices(int[] nums) {
        int N = 100000;
        int[] sum = new int[N];
        int[] count = new int[N];
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int i;
        for(i = 1; i <= nums.length; i ++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for(i = 1; i <= nums.length; i ++){
            if(nums[i - 1] == 0){
                count[i] = count[i - 1] + 1;
            }else{
                count[i] = count[i - 1];
            }
        }
        for(i = 0; i <= nums.length; i ++){
            int num = count[i] + sum[nums.length] - sum[i];
            if(num > max){
                list = new ArrayList<>();
                list.add(i);
                max = num;
            }else if(num == max){
                list.add(i);
            }
        }
        return list;
    }
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int a = 'a';
        int x = 0,n = 0;
        char[] ch = s.toCharArray();
        String res = "";
        for (int i = 0; i <= ch.length-k; i++) {
            for (int j = 0;j < k;j++){
                res = res + ch[i+j];
                n = ch[i+j] - a + 1;
                x = (x % modulo + (n * (int)Math.pow(power,j)) % modulo) % modulo;
            }
            if (x % modulo == hashValue)
                break;
            else {
                res = "";
                x = 0;
            }
        }
        return res;
    }
    private Map<Integer, Integer> map = new HashMap<>(), size = new HashMap<>();
    int groups, maxSize;
    public  int[] groupStrings(String[] words) {
        groups = words.length;
        for (String word : words) {
            int x = 0;
            for (char c : word.toCharArray()) {
                x |= 1 << (c - 'a');
            }
            map.put(x, x);
            size.put(x, size.getOrDefault(x, 0) + 1);
            maxSize = Math.max(maxSize, size.get(x));
            if (size.get(x) > 1) {
                groups--;
            };
        }
        map.forEach((x, fx) -> {
            for (int i = 0; i < 26; i++) {
                merge(x, x ^ (1 << i));
                if (((x >> i) & 1 )== 1) {
                    for (int j = 0; j < 26; j++) {
                        if (((x >> j) & 1)== 0)
                            merge(x, x ^ (1 << i) | (1 << j));
                    }
                }
            }
        });
        return new int[]{groups, maxSize};
    }
    public void merge(int x, int y) {
        if (!map.containsKey(y)) return;
        int a = find(x);
        int b = find(y);
        if (a == b) return;
        map.put(a, b);
        size.put(b, size.get(a) + size.get(b));
        maxSize = Math.max(maxSize, size.get(b));
        groups--;
    }
    public int find(int idx) {
        if (map.get(idx) != idx) {
            map.put(idx, find(map.get(idx)));
        }
        return map.get(idx);
    }
}
