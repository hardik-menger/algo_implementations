package CSES;

import java.util.Arrays;
import java.util.Scanner;

class CoinChange {
    static long M = 1000000007;

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

    // min coins
    public static int minCoins(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - S[j] >= 0 && dp[i - S[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - S[j]] + 1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    // min ways
    public static int minWays(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                dp[j] += dp[j - S[i]];
        return dp[n];
    }

    // total ways
    public static int totalWays(int S[], int m, int n) {
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

    // min
    public static int minCoinss2(int coins[], int sum) {
        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][sum + 1];

        // Initialising first row with +ve infinity
        for (int j = 0; j <= sum; j++) {
            arr[0][j] = Double.POSITIVE_INFINITY;
        }

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            arr[i][0] = 0;
        }

        // Implementing the recursive solution
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j)
                    arr[i][j] = Math.min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }

        return (int) arr[totalCoins][sum];
    }

    // total ways
    public static int totalWays2(int coins[], int sum) {
        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][sum + 1];

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            arr[i][0] = 1;
        }

        // Implementing the recursive solution
        for (int j = 1; j <= sum; j++) {
            for (int i = 1; i <= totalCoins; i++) {
                if (coins[i - 1] <= j)
                    arr[i][j] = arr[i][j - 1] + arr[i][j - coins[i - 1]];
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }

        return (int) arr[totalCoins][sum];
    }

    // min ways
    public static double minWays2(int coins[], int sum) {
        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        int[][] arr = new int[totalCoins + 1][sum + 1];

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            arr[i][0] = 1;
        }

        // Implementing the recursive solution
        for (int i = 0; i < totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {
                if (i == 0) {
                    arr[i][j] = (j % coins[i - 1] == 0) ? 1 : 0;
                } else {
                    arr[i][j] = arr[i - 1][j];
                    if (j >= coins[i - 1])
                        arr[i][j] += arr[i][j - coins[i - 1]];
                }
            }
        }

        return arr[totalCoins][sum] % M;
    }

    // Driver code
    public static void main(String args[]) {
        // int arr[] = { 2, 3, 5, 4 };
        // int n = 9, m = arr.length;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int arr[] = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        // System.out.println(minWays2(arr, n));
        // System.out.println(totalWays2(arr, n));
        System.out.println(minWays(arr, arr.length, n));
        // System.out.println(totalWays(arr, arr.length, n));

    }
}
