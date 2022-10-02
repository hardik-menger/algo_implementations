class Solution {
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 1)
                        dp[i][j][k] = Math.max(dp[i + 1][1][k], -prices[i] + dp[i + 1][0][k]);
                    else
                        dp[i][j][k] = Math.max(dp[i + 1][0][k], prices[i] + dp[i + 1][1][k - 1]);

                }
            }
        }
        return dp[0][1][2];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int next[][] = new int[2][3];
        int curr[][] = new int[2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 1)
                        curr[j][k] = Math.max(next[1][k], -prices[i] + next[0][k]);
                    else
                        curr[j][k] = Math.max(next[0][k], prices[i] + next[1][k - 1]);

                }
            }
            next = curr;
        }
        return next[1][2];
    }
}