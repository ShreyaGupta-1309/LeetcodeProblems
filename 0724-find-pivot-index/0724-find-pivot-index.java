class Solution {
    public int pivotIndex(int[] nums) {
        int cursum = 0;
        int sum =0;
        for(int a : nums){
            sum += a;
        }

        for(int i = 0; i < nums.length ; i++){
            cursum += nums[i];
            if((sum - cursum) == (cursum - nums[i]) )return i;
        }
        return -1;
    }
}