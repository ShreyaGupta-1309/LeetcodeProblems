class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n + 1];

        for(int i = 0; i < n; i++)
        sum[i + 1] = sum[i] + stoneValue[i];

        int[][] dp = new int[n][n];
        for(int len = 2; len <= n; len++){
            for(int l = 0; l + len <= n; l++){
                int r = l + len - 1;
                for(int k = l; k < r; k++){
                    int left = sum[k + 1] - sum[l];
                    int right = sum[r + 1] - sum[k + 1];
                    if(left <= right)
                    dp[l][r] = Math.max(dp[l][r], left + dp[l][k]);
                    if(right <= left)
                    dp[l][r] = Math.max(dp[l][r], right + dp[k + 1][r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}