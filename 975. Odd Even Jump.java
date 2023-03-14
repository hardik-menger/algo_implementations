import java.util.*;
import random.*;

class L975 {

    public int oddEvenJumps(int[] A) {
        int n = A.length, count = 1;
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = dp[n - 1][1] = true;
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        bst.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> floor = bst.floorEntry(A[i]), ceiling = bst.ceilingEntry(A[i]);
            if (floor != null) {
                dp[i][0] = dp[floor.getValue()][1];
            }
            if (ceiling != null) {
                dp[i][1] = dp[ceiling.getValue()][0];
            }
            if (dp[i][1]) {
                count++;
            }
            bst.put(A[i], i);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L975 obj = new L975();
    }
}
