class Solution {
    public void gameOfLife(int[][] board) {
       int m = board.length, n = board[0].length;

        int[] d = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int c = 0;
                for (int x : d) {
                    for (int y : d) {
                        if (x == 0 && y == 0) continue;

                        int r = i + x, s = j + y;

                        if (r >= 0 && r < m && s >= 0 && s < n) {
                            if (Math.abs(board[r][s]) == 1) c++;
                        }
                    }
                }
                if (board[i][j] == 1 && (c < 2 || c > 3)) {
                    board[i][j] = -1;
                }

                if (board[i][j] == 0 && c == 3) {
                    board[i][j] = 2; 
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        } 
    }
}