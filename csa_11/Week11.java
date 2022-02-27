package csa_11;

import java.util.Arrays;
import java.util.Comparator;

public class Week11 {
    public static void main(String[] args) {
        new Week11().test();
    }
    public void test() {
        int[]nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        int[]flowerbed = {1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed,n));
        int[][]intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 1 , count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (num > 2) {
                    count += (num -1)/2;
                }
                num = 0;
            } else {
                num++;
            }
        }
        num++;
        if (num > 2) {
            count += (num -1)/2;
        }
        return count >= n;
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
