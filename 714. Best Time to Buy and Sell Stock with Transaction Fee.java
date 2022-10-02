class Solution {

    // refer 122 first
    public int maxProfit(int[] prices, int fee) {
        int aheadBuy = 0, aheadSell = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int newSell = Math.max(prices[i] - fee + aheadBuy, aheadSell);
            int newBuy = Math.max(-prices[i] + aheadSell, aheadBuy);
            aheadSell = newSell;
            aheadBuy = newBuy;
        }
        return aheadBuy;
    }
}