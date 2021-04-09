class WordSearch {
    public boolean exist(char[][] board, String words) {
        int m = board.length, n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (words.charAt(0) == board[i][j] && solve(board, words, visited, i, j, 1))
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

    private boolean solve(char[][] board, String words, boolean visited[][], int i, int j, int charIndex) {
        int m = board.length, n = board[0].length;

        visited[i][j] = true;

        if (charIndex == words.length())
            return true;

        char resChar = words.charAt(charIndex);

        if (this.isValid(m, n, i + 1, j) && resChar == board[i + 1][j] && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            if (solve(board, words, visited, i + 1, j, charIndex + 1))
                return true;
        }
        if (this.isValid(m, n, i - 1, j) && resChar == board[i - 1][j] && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            if (solve(board, words, visited, i - 1, j, charIndex + 1))
                return true;
        }
        if (this.isValid(m, n, i, j + 1) && resChar == board[i][j + 1] && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            if (solve(board, words, visited, i, j + 1, charIndex + 1))
                return true;
        }
        if (this.isValid(m, n, i, j - 1) && resChar == board[i][j - 1] && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            if (solve(board, words, visited, i, j - 1, charIndex + 1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String args[]) {
        WordSearch wordSearch = new WordSearch();
        char res[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String ip = "SEE";
        System.out.println(wordSearch.exist(res, ip));
    }
}
