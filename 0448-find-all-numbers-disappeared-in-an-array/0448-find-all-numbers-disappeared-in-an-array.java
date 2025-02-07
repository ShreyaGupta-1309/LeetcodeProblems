class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     int n = nums.length;
     int[] arr = new int [n + 1];
     List<Integer>list = new ArrayList<>();
     for(int i = 0; i < nums.length; i++){
        arr[nums[i]] = nums[i];
     }
     for(int j = 1; j <arr.length; j++){
        if(arr[j] == 0)
           list.add(j);
     }
     return list;
    }
}