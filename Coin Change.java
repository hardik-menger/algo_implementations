import java.util.Arrays;

class CoinChange {
    static int count(int S[], int m, int n) {

        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
    }

    static int count1(int S[], int dp[][], int index, int sum) {
        if (sum == 0)
            return 1;

        if (index >= dp.length || sum < 0)
            return 0;

        if (dp[index][sum] != -1)
            return dp[index][sum];

        int left = count1(S, dp, index, sum - S[index]);
        int right = count1(S, dp, index + 1, sum);

        int ans = left + right;
        dp[index][sum] = ans;

        return ans;
    }

    public static int count2(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                dp[j] += dp[j - S[i]];
        return dp[n];
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 1, 2, 5 };
        int n = 5, m = arr.length;
        // int dp[][] = new int[arr.length][n + 1];
        // for (int i = 0; i < arr.length; i++)
        // Arrays.fill(dp[i], -1);
        // System.out.println(count1(arr, dp, 0, n));
        System.out.println(count2(arr, m, n));

    }
}
