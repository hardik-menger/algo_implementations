class Solution188 {
    public int maxProfit(int maxTransaactions, int[] prices) {
        int n = prices.length;
        int next[][] = new int[2][maxTransaactions + 1];
        int curr[][] = new int[2][maxTransaactions + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= maxTransaactions; k++) {
                    if (j == 1)
                        curr[j][k] = Math.max(next[1][k], -prices[i] + next[0][k]);
                    else
                        curr[j][k] = Math.max(next[0][k], prices[i] + next[1][k - 1]);

                }
            }
            next = curr;
        }
        return next[1][maxTransaactions];
    }
}