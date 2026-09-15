class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) pal[i][i] = true;

        for(int i = 1; i < n; i++) if(s.charAt(i) == s.charAt(i - 1))pal[i-1][i] = true;

        for(int len = 3; len <= n; len++){
            for(int j = 0; j + len <= n; j++){
                if(s.charAt(j) == s.charAt(j + len - 1) &&
                pal[j + 1][j + len - 2]){
                    pal[j][j + len - 1] = true;
                }
            }
        }
        int dp[] = new int[n];

        for(int i = 0; i < n; i++){
            if(i > 0) dp[i] = dp[i - 1];
            for(int j = 0; j <= i; j++){
                if(i - j + 1 >= k&& pal[j][i]){
                    dp[i] = Math.max(dp[i], 1 + (j > 0 ? dp[j - 1] : 0));
                }
            }
        }
        return dp[n - 1];
    }
}