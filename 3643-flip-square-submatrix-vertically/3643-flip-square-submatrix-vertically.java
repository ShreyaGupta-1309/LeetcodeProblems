class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sc = y, ec = y + k - 1, sr = x;
        for(int j = sc; j <= ec; j++){
            for(int i = 0; i < k/2; i++){
                int temp = grid[sr+i][j];
                grid[sr+i][j] = grid[sr+k-i-1][j];
                grid[sr+k-i-1][j] = temp;
            }
        }
        return grid;
    }
}