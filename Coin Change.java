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

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int n = 4;
        int dp[][] = new int[arr.length][n + 1];
        for (int i = 0; i < arr.length; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(count1(arr, dp, 0, n));
    }
}
