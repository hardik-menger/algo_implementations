class Solution {
    public int maxProfit(int[] prices) {
        int[] nostock = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        nostock[0] = 0;
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            nostock[i] = Math.max(nostock[i - 1], sell[i - 1]);
            buy[i] = Math.max(nostock[i - 1] - prices[i], buy[i - 1]);
            sell[i] = buy[i - 1] + prices[i];
        }
        int ans = Math.max(nostock[prices.length - 1], sell[prices.length - 1]);
        return ans;
    }
}