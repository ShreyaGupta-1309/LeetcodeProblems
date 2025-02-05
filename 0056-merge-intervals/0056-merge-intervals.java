class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (arr1 , arr2) -> arr1[0] - arr2[0]);
        List<int[]>output = new ArrayList<>();
        int[]curr = intervals[0];
        output.add(curr);

        for(int[] interval : intervals){
            int currend = curr[1];
            int nextbegin = interval[0];
            int nextend = interval[1];

            if(currend >= nextbegin){
                curr[1] = Math.max(currend , nextend);
            }else {
                curr = interval;
                output.add(curr);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}