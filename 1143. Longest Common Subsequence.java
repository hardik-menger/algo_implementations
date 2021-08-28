class LCS {
    public static int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    public static int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i == -1 || j == -1)
            return 0;
        if (text1.charAt(i) == text2.charAt(j))
            return 1 + longestCommonSubsequence(text1, text2, i - 1, j - 1);
        if (text1.charAt(i) != text2.charAt(j))
            return Math.max(longestCommonSubsequence(text1, text2, i - 1, j),
                    longestCommonSubsequence(text1, text2, i, j - 1));
        return longestCommonSubsequence(text1, text2, i, j);
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of LCS: " + longestCommonSubsequence(X, Y));

    }
}

class LCSDP {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[2][n + 1];
        int bi = 0;
        for (int i = 0; i <= m; i++) {
            bi = i & 1;
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[bi][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[bi][j] = dp[1 - bi][j - 1] + 1;
                } else {
                    dp[bi][j] = Math.max(dp[bi][j - 1], dp[1 - bi][j]);
                }
            }
        }
        return dp[bi][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of LCS: " + longestCommonSubsequence(X, Y));

    }
}