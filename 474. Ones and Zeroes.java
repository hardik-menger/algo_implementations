import java.util.*;
import random.*;

class L474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeroCount = count(s), oneCount = s.length() - zeroCount;
            for (int i = m; i >= zeroCount; i--)
                for (int j = n; j >= oneCount; j--)
                    if (i - zeroCount >= 0 && j - oneCount >= 0)
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - zeroCount] + s.charAt(i));
        }
        return dp[m][n];
    }

    private int count(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '0')
                count++;
        return count;
    }

    public static void main(String[] args) throws Exception {
        L474 obj = new L474();
    }
}
