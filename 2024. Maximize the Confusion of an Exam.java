import java.util.*;
import random.*;

class L2024 {

    public int maxConsecutiveAnswers1(String answerKey, int k) {
        return Math.max(solve(answerKey, k, 'F'), solve(answerKey, k, 'T'));
    }

    private int solve(String answerKey, int k, char symbol) {
        int i = 0, j = 0;
        int ans = 0;
        while (j < answerKey.length()) {
            char ch = answerKey.charAt(j);
            if (ch == symbol && k == 0) {
                while (answerKey.charAt(i) != symbol)
                    i++;
                i++;
            } else if (ch == symbol) {
                k--;
            }
            j++;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    public int maxConsecutiveAnswers(String s, int k) {
        int mostoccuring = 0, i = 0, n = s.length(), fcount = 0, tcount = 0;
        int ans = 0;
        int original = k;
        for (int j = 0; j < n; ++j) {
            if (s.charAt(j) == 'F') {
                fcount++;
                mostoccuring = Math.max(mostoccuring, fcount);
            } else {
                tcount++;
                mostoccuring = Math.max(mostoccuring, tcount);
            }
            while (fcount + tcount > mostoccuring + k) {
                if (s.charAt(i++) == 'F') {
                    fcount--;
                } else {
                    tcount--;
                }
            }
            if (k != 0)
                ans = Math.max(ans, fcount + tcount);

        }
        if (original == 0)
            ans = Math.max(fcount, tcount);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L2024 obj = new L2024();
        System.out.println(obj.maxConsecutiveAnswers("TTFTT", 0));
        System.out.println(obj.maxConsecutiveAnswers("TTFTT", 1));
        System.out.println(obj.maxConsecutiveAnswers("TTFFTT", 1));
        System.out.println(obj.maxConsecutiveAnswers("TTFFTTFFTT", 4));
    }
}
