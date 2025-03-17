class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int pairs = 0;
        for(int i = 0; i < nums.length; i += 2){
            if(nums[i] == nums[i+1]){
                pairs++;
            }
        }if(nums.length/2 == pairs) return true;
        else return false;
    }
}
