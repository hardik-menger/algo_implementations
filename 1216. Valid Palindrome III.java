import java.util.*;

import random.Pair;
import random.TreeNode;

class L1216 {

    /**
     * @param s
     * @param k
     * @return
     */
    boolean isValidPalindrome(String s, int k) {
        return recursive(s, 0, s.length() - 1, k) <= k;
    }

    int recursive(String s, int l, int r, int k) {
        if (l == r)
            return 0;
        if (l + 1 == r)
            return s.charAt(l + 1) == s.charAt(r) ? 0 : 1;
        int ans = 1 + Math.min(recursive(s, l + 1, r, k), recursive(s, l, r + 1, k));
        if (s.charAt(l) == s.charAt(r))
            ans = Math.min(ans, recursive(s, l + 1, r - 1, k));
        return ans;
    }

    boolean isValidPalindrome1(String s, int k) {
        int dp[][] = new int[s.length()][s.length() + 1];
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][2] = s.charAt(i) != s.charAt(i + 1) ? 1 : 0;
        }
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                dp[i][length] = 1 + Math.min(dp[i][length - 1], dp[i + 1][length - 1]);
                if (s.charAt(i) == s.charAt(i + length - 1))
                    dp[i][length] = Math.min(dp[i][length], dp[i + 1][length - 2]);
            }
        }
        return dp[0][s.length()] <= k;
    }

    public static void main(String[] args) throws Exception {
        L1216 obj = new L1216();
    }
}
