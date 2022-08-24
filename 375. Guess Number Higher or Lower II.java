import java.util.*;
import random.*;

class L375 {

    public int getMoneyAmount1(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int[] a : dp)
            Arrays.fill(a, Integer.MAX_VALUE);
        return recur(1, n, dp);
    }

    private int recur(int left, int right, int[][] dp) {
        if (left >= right)
            return 0;

        if (dp[left][right] != Integer.MAX_VALUE)
            return dp[left][right];

        // min becuase we need minimum value across all possible hgeussses
        for (int j = left; j <= right; j++) {
            dp[left][right] = Math.min(
                    dp[left][right], Math.max(j + recur(left, j - 1, dp), j + recur(j + 1, right, dp)));
        }
        return dp[left][right];
    }

    public int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int cost = Integer.MAX_VALUE;
                int j = i + len - 1;
                for (int pivot = i; pivot <= j; pivot++) {
                    cost = Math.min(cost, pivot + Math.max((pivot - 1 >= i ? dp[i][pivot - 1] : 0),
                            (pivot + 1 <= j ? dp[pivot + 1][j] : 0)));
                }
                dp[i][j] = cost;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) throws Exception {
        L375 obj = new L375();
        System.out.println(obj.getMoneyAmount(10));
    }
}
