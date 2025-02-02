class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null && nums.length == 0){
            return 0;
        }
        Set<Integer>set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        for(int num : set){
            if(!set.contains (num -1)){
                int currentNum = num;
                int currentLength = 1;
                 while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentLength++;
                }
                max = Math.max(max , currentLength);
            }  
        }  
        return max; 
    }
}