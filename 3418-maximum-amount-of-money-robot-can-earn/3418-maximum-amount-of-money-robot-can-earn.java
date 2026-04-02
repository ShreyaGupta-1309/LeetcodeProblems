class Solution {
    private int[][][] dp;
    private int min  = Integer.MIN_VALUE;
    public int maximumAmount(int[][] coins) {
        int n =coins.length;
        int m = coins[0].length;
        dp =new int[n][m][3];
        for(int[][] arr: dp){
            for(int[] a : arr){
                Arrays.fill(a,min);
            }
        }
        return find(n-1,m-1,2, coins);
    }
    private int find(int i, int j, int k, int[][] coin){
        
        if(i<0|| j<0)return -1000000;
        if(i==0 && j==0){
            if(coin[i][j]<0 && k>0)return 0;

            return coin[i][j];
        }
        if(dp[i][j][k]!=min)return dp[i][j][k];
        int take = min;
        int val = coin[i][j];
        if(val<0 && k>0){
            take = Math.max(find(i,j-1,k-1,coin),find(i-1,j,k-1,coin));
        }
        int notake = val+Math.max(find(i,j-1,k,coin),find(i-1,j,k,coin));
        return dp[i][j][k]=Math.max(take,notake);
    }
}