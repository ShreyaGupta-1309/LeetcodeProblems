class Solution {
    public int[] searchRange(int[] nums, int target) {
       int leftRound  = leftRound(nums,target);

       int rightRound = rightRound(nums,target);
       return new int []{leftRound, rightRound};
    }
    public static int leftRound(int nums[] , int target){
        int index = -1;
        int start = 0 , end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                index = mid;
                end = mid -1;
            }
            else if(nums[mid]< target) start = mid+1;
            else end = mid-1;
        }
        return index;
    }
    public static int rightRound(int nums[] , int target){
        int index = -1;
        int start =0 , end = nums.length-1;
         while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                index = mid;
                start = mid + 1;
            }
            else if(nums[mid]< target) start = mid + 1;
            else end = mid-1;
        }
        return index;
    }
}