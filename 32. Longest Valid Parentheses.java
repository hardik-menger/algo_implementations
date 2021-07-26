class LongestValidParentheses {
    public int longestValidParentheses1(String s) {
        if (s == null)
            return -1;
        if (s.length() == 0)
            return 0;
        char[] str = s.toCharArray();
        int sum = 0, res = 0, len = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(')
                sum++;
            else
                sum--;
            if (sum < 0) {
                sum = 0;
                len = 0;
            } else {
                len++;
                if (sum == 0)
                    res = Math.max(res, len);
            }
        }
        sum = 0;
        len = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == ')')
                sum++;
            else
                sum--;
            if (sum < 0) {
                sum = 0;
                len = 0;
            } else {
                len++;
                if (sum == 0)
                    res = Math.max(res, len);
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        char c[] = s.toCharArray();
        int dp[] = new int[c.length];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            if (c[i] == ')' && c[i - 1] == '(') {
                dp[i] = i - 2 >= 0 ? dp[i - 2] : 0 + 2;
            } else if (i - dp[i - 1] - 1 >= 0 && c[i] == ')' && c[i - 1] == ')') {
                if (c[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2 >= 0 ? i - dp[i - 1] - 2 : 0] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
