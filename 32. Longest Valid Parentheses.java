class LongestValidParentheses {
    public int longestValidParentheses(String s) {
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
}
