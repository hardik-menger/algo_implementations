class GameofLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int living = getLivingNeighBoursNumber(board, i, j);
                if (board[i][j] == 1 && (living == 2 || living == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && living == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = board[i][j] >> 1;
    }

    private int getLivingNeighBoursNumber(int[][] board, int i, int j) {
        int left = Math.max(i - 1, 0);
        int right = Math.min(i + 1, board.length - 1);
        int top = Math.max(j - 1, 0);
        int bottom = Math.min(j + 1, board[i].length - 1);
        int lives = 0;
        for (int p = left; p <= right; p++) {
            for (int q = top; q <= bottom; q++) {
                if (p == i && q == j)
                    continue;
                lives += (board[p][q] == 1 || board[p][q] == 3) ? 1 : 0;
            }
        }
        return lives;
    }
}
