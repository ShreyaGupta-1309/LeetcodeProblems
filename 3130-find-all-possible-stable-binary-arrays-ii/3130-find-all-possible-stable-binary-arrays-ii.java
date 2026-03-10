class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        long[][][] dp = new long[zero + 1][one + 1][2];

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int i = 0; i <= zero; i++){
            for(int j = 0; j <= one; j++){

                if(i == 0 && j == 0) continue;

                long endWithZero = 0;
                long endWithOne = 0;
                
                if(j > 0){
                    endWithZero = dp[i][j - 1][1];

                    if(j > 1)
                       endWithZero = (endWithZero + dp[i][j - 1][0]) % MOD;

                    if(j > limit)
                       endWithZero = (endWithZero - dp[i][j - 1 - limit][1] + MOD) % MOD;
                }
                if(i > 0){
                    endWithOne = dp[i - 1][j][0];

                    if(i > 1)
                       endWithOne = (endWithOne + dp[i - 1][j][1]) % MOD;

                    if(i > limit)
                       endWithOne = (endWithOne - dp[i - 1 - limit][j][0] + MOD) % MOD;
                }
                dp[i][j][0] = endWithZero % MOD;
                dp[i][j][1] = endWithOne % MOD;
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}