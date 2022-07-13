import java.util.*;
import random.*;

class L375 {

    public int getMoneyAmount(int n) {
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

    public static void main(String[] args) throws Exception {
        L375 obj = new L375();
        System.out.println(obj.getMoneyAmount(10));
    }
}
