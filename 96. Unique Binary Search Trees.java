import java.util.Arrays;

class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoize(n, dp);
    }

    private int memoize(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        if (n == 0 || n == 1)
            return 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += memoize(i - 1, dp) * memoize(n - i, dp);
        }
        dp[n] = ans;
        return ans;
    }

    public int numTrees1(int n) {
        if (n == 0 || n == 1)
            return 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees(i - 1) * numTrees(n - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(1));
    }
}