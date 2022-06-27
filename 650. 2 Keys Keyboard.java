import java.util.*;
import random.*;

class L650 {

    public int minSteps(int n) {
        int dp[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i < i; j++)
                if (i % j == 0)
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        L650 obj = new L650();
        try {
            System.out.println(obj.minSteps(3));
            System.out.println(obj.minSteps(2));
            System.out.println(obj.minSteps(1));
        } catch (Exception e) {
        }
    }
}
