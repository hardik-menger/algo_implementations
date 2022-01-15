class CoinChange2No518 {
    public int change(int n, int[] S) {
        int dp[] = new int[n + 1];
        int m = S.length;
        dp[0] = 1;
        for (int j = 0; j < m; j++)
            for (int i = 1; i <= n; i++)
                if (i >= S[j])
                    dp[i] += dp[i - S[j]];
        return dp[n];
    }
}
