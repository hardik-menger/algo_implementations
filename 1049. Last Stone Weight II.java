import java.util.*;
import random.*;

class L1049 {

    public int lastStoneWeightII(int[] stones) {
        int W = Arrays.stream(stones).sum(), n = stones.length;
        boolean[] dp = new boolean[W / 2 + 1];
        dp[0] = true;
        int s = 0;
        for (int i = 0; i < n; i++)
            for (int j = W / 2; j >= stones[i]; j--) {
                dp[j] |= dp[j - stones[i]];
                if (dp[j])
                    s = Math.max(s, j);
            }
        return W - s - s;
    }

    public static void main(String[] args) throws Exception {
        L1049 obj = new L1049();
    }
}
