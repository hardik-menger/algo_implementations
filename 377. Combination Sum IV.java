class CombinationSumIV {
    public int combinationSum4(int[] S, int n) {
        int dp[] = new int[n + 1];
        int m = S.length;
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < m; j++)
                if (i >= S[j])
                    dp[i] += dp[i - S[j]];
        return dp[n];
    }
}
