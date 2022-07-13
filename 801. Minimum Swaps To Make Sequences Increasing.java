import java.util.*;
import random.*;

class L801 {

    int dp[][] = new int[100001][2];

    public int minSwap(int[] nums1, int[] nums2) {
        for (int a[] : dp)
            Arrays.fill(a, -1);
        return recurcive(nums1, nums2, -1, -1, 0, 0);
    }

    private int recurcive(int[] nums1, int[] nums2, int prev, int prev2, int index, int swapped) {
        if (index == nums1.length)
            return 0;
        if (dp[index][swapped] != -1)
            return dp[index][swapped];
        int min = Integer.MAX_VALUE;
        if (nums1[index] > prev && nums2[index] > prev2)
            min = recurcive(nums1, nums2, nums1[index], nums2[index], index + 1, 0);
        if (nums2[index] > prev && nums1[index] > prev2)
            min = Math.min(min, recurcive(nums1, nums2, nums2[index], nums1[index], index + 1, 1) + 1);
        return dp[index][swapped] = min;
    }

    public static void main(String[] args) throws Exception {
        L801 obj = new L801();
    }
}
