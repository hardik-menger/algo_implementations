import java.util.*;
import random.*;

class L688 {

    // refer 576
    public double knightProbability(int n, int N, int row, int column) {
        double dp[][] = new double[n][n];
        int M = (int) 1e9 + 7;
        dp[row][column] = 1;
        int dirs[][] = new int[][] { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 },
                { -2, -1 } };
        for (int level = 1; level <= N; level++) {
            double temp[][] = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int v = 0; v < 8; v++) {
                        int x = i + dirs[v][0];
                        int y = j + dirs[v][1];
                        if (x < 0 || y < 0 || x >= n || y >= n)
                            continue;
                        temp[i][j] += dp[x][y] / 8.0;
                    }
                }
            }

            dp = temp;
        }
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dp[i][j]) % M;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L688 obj = new L688();
    }
}
