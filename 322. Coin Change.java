import java.util.Arrays;

class CoinChange322 {

    static int findWays(int[] coins, int sum) {
        int size = coins.length;
        int[][] arr = new int[size + 1][sum + 1];

        // Initializing first column of array to 1 because
        // a sum of 0 can be made in one
        // possible way: {0}
        for (int i = 0; i < size + 1; i++)
            arr[i][0] = 1;

        // Applying the recursive solution:
        for (int i = 1; i < size + 1; i++)
            for (int j = 0; j < sum + 1; j++)
                if (coins[i - 1] > j) // Cannot pick the highest coin:
                    arr[i][j] = arr[i - 1][j];
                else // Pick the highest coin:
                    arr[i][j] = arr[i][j - coins[i - 1]] + arr[i - 1][j];

        return arr[size][sum];
    }

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
