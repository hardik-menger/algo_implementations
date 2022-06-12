import java.util.*;

class L1392 {

    int[] computeLPSArray(String pat, int M) {
        int len = 0, i = 1;
        int lps[] = new int[M];
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len == 0)
                    lps[i++] = 0;
                else
                    len = lps[len - 1];
            }
        }
        return lps;
    }

    public String longestPrefix(String s) {
        int lps[] = computeLPSArray(s, s.length());
        return s.substring(0, lps[lps.length - 1]);
    }

    public String longestPrefix1(String s) {
        long r = 0, l = 0, p = 1, m = (long) 1e9 + 7;
        int ans = 0, n = s.length();
        for (int i = 0; i < n - 1; i++) {
            l = (l * 128 + s.charAt(i)) % m;
            r = (r + p * s.charAt(n - i - 1)) % m;
            if (l == r)
                ans = i + 1;
            p = p * 128 % m;
        }
        return s.substring(0, ans);
    }

    public static void main(String[] args) throws Exception {
        L1392 obj = new L1392();
    }
}
