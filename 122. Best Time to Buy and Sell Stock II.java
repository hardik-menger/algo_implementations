class Solution {
    public int maxProfit2(int[] prices) {
        return recursive(prices, true, 0);
    }

    private int recursive(int[] prices, boolean canBuy, int i) {
        if (i == prices.length)
            return 0;
        if (canBuy) {
            return Math.max(-prices[i] + recursive(prices, !canBuy, i + 1), recursive(prices, canBuy, i + 1));
        } else {
            return Math.max(prices[i] + recursive(prices, !canBuy, i + 1), recursive(prices, canBuy, i + 1));
        }
    }

    public int maxProfit3(int[] prices) {
        int dp[][] = new int[prices.length + 1][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            dp[i][0] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
        }
        return dp[0][1];
    }

    public int maxProfit4(int[] prices) {
        int dp[] = new int[2];
        for (int i = prices.length - 1; i >= 0; i--) {
            int newSell = Math.max(prices[i] + dp[1], dp[0]);
            int newBuy = Math.max(-prices[i] + dp[0], dp[1]);
            dp[0] = newSell;
            dp[1] = newBuy;
        }
        return dp[1];
    }

    public int maxProfit(int[] prices) {
        int aheadBuy = 0, aheadSell = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int newSell = Math.max(prices[i] + aheadBuy, aheadSell);
            int newBuy = Math.max(-prices[i] + aheadSell, aheadBuy);
            aheadSell = newSell;
            aheadBuy = newBuy;
        }
        return aheadBuy;
    }

    public int maxProfit(int[] prices, int fee) {
        int aheadBuy = 0, aheadSell = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int newSell = Math.max(prices[i] + aheadBuy, aheadSell);
            int newBuy = Math.max(-prices[i] + fee + aheadSell, aheadBuy);
            aheadSell = newSell;
            aheadBuy = newBuy;
        }
        return aheadBuy;
    }
}