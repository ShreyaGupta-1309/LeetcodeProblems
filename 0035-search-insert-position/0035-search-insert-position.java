class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        for(int i = 0; i < nums.length; i++){
            if (nums[i] < target) continue;
            else return i;
        }
        return nums.length;
    }
}