class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * n + n)/2;
        int arrsum = 0;
        for(int i = 0 ; i< nums.length ; i++){
            arrsum += nums[i];
        }
        return sum - arrsum;
    }
}