import java.util.*;
import random.*;

class L576 {
    public static void main(String[] args) throws Exception {
        L576 obj = new L576();
    }

    // https://www.youtube.com/watch?v=I_56rUK_Ui8
    public int findPaths(int m, int n, int N, int ii, int jj) {
        int dp[][] = new int[m][n];
        int M = (int) 1e9 + 7;
        dp[ii][jj] = 1;
        int ans = 0;
        for (int level = 1; level <= N; level++) {
            int temp[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int left = i > 0 ? dp[i - 1][j] : 0;
                    int right = i < m - 1 ? dp[i + 1][j] : 0;
                    int top = j > 0 ? dp[i][j - 1] : 0;
                    int bottom = j < n - 1 ? dp[i][j + 1] : 0;

                    temp[i][j] = (left + temp[i][j]) % M;
                    temp[i][j] = (right + temp[i][j]) % M;
                    temp[i][j] = (bottom + temp[i][j]) % M;
                    temp[i][j] = (top + temp[i][j]) % M;
                }
            }
            for (int i = 0; i < m; i++) {
                ans = (ans + dp[i][0]) % M;
                ans = (ans + dp[i][n - 1]) % M;
            }
            for (int i = 0; i < n; i++) {
                ans = (ans + dp[0][i]) % M;
                ans = (ans + dp[m - 1][i]) % M;
            }
            dp = temp;

        }
        return ans;
    }
}
