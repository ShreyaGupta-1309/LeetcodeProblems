class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer , Integer>map = new HashMap<>();
        long count = 0;
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;

        for(int i = 0; i< n; i++){
            int diff = i - nums[i];
            count += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return totalPairs - count;
    }
}