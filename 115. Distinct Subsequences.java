import java.util.*;
import random.*;

class L115 {

    public int numDistinct1(String s, String t) {
        return recur(s, t, 0, 0, new HashMap<String, Integer>());
    }

    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];

            }
        }
        return dp[s.length()][t.length()];
    }

    private int recur(String s, String t, int i, int progress, HashMap<String, Integer> hm) {
        if (hm.containsKey(i + ":" + progress))
            return hm.get(i + ":" + progress);
        if (progress == t.length())
            return 1;
        if (i == s.length())
            return 0;
        int ans = 0;
        if (s.charAt(i) == t.charAt(progress))
            ans = recur(s, t, i + 1, progress + 1, hm) + recur(s, t, i + 1, progress, hm);
        else
            ans = recur(s, t, i + 1, progress, hm);
        hm.put(i + ":" + progress, ans);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L115 obj = new L115();
        System.out.println(obj.numDistinct("rabbbit", "rabbit"));
        System.out.println(obj.numDistinct("babgbag", "bag"));
    }
}
