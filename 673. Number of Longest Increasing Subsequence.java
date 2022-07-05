import java.util.*;
import random.*;

class L673 {

    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        int maxlen = 1, ans = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        for (int i = 0; i < nums.length; i++)
            if (dp[i] == maxlen)
                ans += count[i];
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L673 obj = new L673();
    }
}
