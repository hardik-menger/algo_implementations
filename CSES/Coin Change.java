package CSES;

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

    public static int count2(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                dp[j] += dp[j - S[i]];
        return dp[n];
    }

    public static int count3(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++)
            for (int i = 0; i < m; i++) {
                if (S[i] > j)
                    continue;
                dp[j] += dp[j - S[i]];
            }
        return dp[n];
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 2, 3, 5 };
        int n = 9, m = arr.length;
        System.out.println(count(arr, m, n));
        System.out.println(count2(arr, m, n));
        System.out.println(count3(arr, m, n));

    }
}
