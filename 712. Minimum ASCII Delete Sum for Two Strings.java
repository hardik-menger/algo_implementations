import java.util.*;
import random.*;

class L712 {

    public int minimumDeleteSum1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + text1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < text1.length(); i++)
            sum += text1.charAt(i);
        for (int i = 0; i < text2.length(); i++)
            sum += text2.charAt(i);
        return sum - 2 * dp[m][n];

    }

    public int minimumDeleteSum(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = dp[i - 1][0] + text1.charAt(i - 1);
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] + text2.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + text2.charAt(j - 1), dp[i - 1][j] + text1.charAt(i - 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) throws Exception {
        L712 obj = new L712();
    }
}
