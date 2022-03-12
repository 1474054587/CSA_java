package CSA.csa_13;

public class Week13 {
    public static void main(String[] args) {
        new Week13().test();
    }
    public void test(){
        int[]nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }
    public int subarraySum(int[] nums, int k) {
        int n = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)n++;
            }
            sum = 0;
        }
        return n;
    }
}
