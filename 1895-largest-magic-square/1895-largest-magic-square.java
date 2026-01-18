class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row_prefix = new int[m][n + 1], col_prefix = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) row_prefix[i][j + 1] = row_prefix[i][j] + grid[i][j];
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) col_prefix[i + 1][j] = col_prefix[i][j] + grid[i][j];
        }

        int[][] main_diag = new int[m + 1][n + 1], anti_diag = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) main_diag[i + 1][j + 1] = main_diag[i][j] + grid[i][j];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) anti_diag[i + 1][j] = anti_diag[i][j + 1] + grid[i][j];
        }

        int max_k = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max_possible_k = Math.min(m - i, n - j);
                for (int k = max_possible_k; k > max_k; k--) {
                    if (is_magic(grid, i, j, k, row_prefix, col_prefix, main_diag, anti_diag)) {
                        max_k = Math.max(max_k, k);
                        break;  
                    }
                }
            }
        }

        return max_k;
    }

    private boolean is_magic(int[][] grid, int r, int c, int k, 
                           int[][] row_prefix, int[][] col_prefix,
                           int[][] main_diag, int[][] anti_diag) {
        if (k == 1) return true;
        
        int target = row_prefix[r][c + k] - row_prefix[r][c];
        
        for (int i = r + 1; i < r + k; i++) {
            int sum = row_prefix[i][c + k] - row_prefix[i][c];
            if (sum != target) return false;
        }
        
        for (int j = c; j < c + k; j++) {
            int sum = col_prefix[r + k][j] - col_prefix[r][j];
            if (sum != target) return false;
        }
        
        int main_sum = main_diag[r + k][c + k] - main_diag[r][c];
        if (main_sum != target) return false;
        
        int anti_sum = anti_diag[r + k][c] - anti_diag[r][c + k];
        if (anti_sum != target) return false;
        
        return true;
    }
}