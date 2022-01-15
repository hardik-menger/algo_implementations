import java.util.Arrays;

class CoinChange322 {
    public int coinChange(int S[], int target) {
        int n = S.length;
        int dp[] = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {

                if (S[i] <= j && dp[j - S[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - S[i]] + 1);
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}
