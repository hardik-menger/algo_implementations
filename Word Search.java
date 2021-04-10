class WordSearch {
    public boolean exist(char[][] board, String words) {
        int m = board.length, n = board[0].length;
        words = words.toUpperCase();
        boolean visited[][] = new boolean[m][n];
        if (ispresent(words, board))
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (words.charAt(0) == board[i][j] && solve(board, words, visited, i, j, 0))
                        return true;
                }
            }
        return false;
    }

    boolean isValid(int m, int n, int x, int y) {
        if (x < m && x >= 0 && y < n && y >= 0)
            return true;
        return false;
    }

    boolean ispresent(String words, char[][] board) {
        int[] A = new int[26];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = Character.toUpperCase(board[i][j]);
                A[board[i][j] - 'A']++;
            }
        }

        for (int i = 0; i < words.length(); ++i) {
            char t = Character.toUpperCase(words.charAt(i));

            A[t - 'A']--;
            if (A[t - 'A'] < 0)
                return false;
        }
        return true;

    }

    private boolean solve(char[][] board, String words, boolean visited[][], int i, int j, int charIndex) {
        int m = board.length, n = board[0].length;
        if (charIndex == words.length())
            return true;

        if (!this.isValid(m, n, i, j) || visited[i][j] == true) {
            return false;
        }
        visited[i][j] = true;

        char resChar = words.charAt(charIndex);
        boolean res = false;
        if (resChar == board[i][j]) {
            res = solve(board, words, visited, i + 1, j, charIndex + 1)
                    || solve(board, words, visited, i - 1, j, charIndex + 1)
                    || solve(board, words, visited, i, j + 1, charIndex + 1)
                    || solve(board, words, visited, i, j - 1, charIndex + 1);
        }
        visited[i][j] = false;
        return res;
    }

    public static void main(String args[]) {
        WordSearch wordSearch = new WordSearch();
        char res[][] = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
        String ip = "AAAAA";
        System.out.println(wordSearch.exist(res, ip));
    }
}
