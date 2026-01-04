class Solution {
    private int factors(int n){
        int sum = 0, s = 0;
     for(int i = 2; i*i <= n; i++){
        if(n % i == 0){
            int j = n / i;
            if(j == i || s > 0) return 0;
            sum += i + j;
            s++;
        }
     }
     if(s == 0) return 0;
     return 1 + sum + n;
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += factors(nums[i]);
        }
        return sum;
    }
}