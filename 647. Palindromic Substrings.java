import java.util.*;
import random.*;

class L647 {
    public int countSubstrings(String S) {
        boolean dp[][] = new boolean[S.length()][S.length()];
        int n = S.length();
        int count = 0;
        for (int s = 0; s < n; s++) {
            for (int i = 0; i + s < n; i++) {
                if (S.charAt(i) == S.charAt(i + s)) {
                    dp[i][i + s] = s <= 2 ? true : dp[i + 1][i + s - 1];
                    if (dp[i][i + s])
                        count++;
                }
            }
        }
        return count;
    }

    int count = 0;

    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0)
            return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) throws Exception {
        L647 obj = new L647();
    }
}
