import java.util.*;
import random.*;

class L719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int mindiff = nums[1] - nums[0];
        for (int i = 1; i < nums.length - 1; i++)
            mindiff = Math.min(mindiff, nums[i + 1] - nums[i]);
        int maxdiff = nums[nums.length - 1] - nums[0];
        int l = mindiff, r = maxdiff;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, k)) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] a, int mid, int k) {
        int n = a.length, res = 0;
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < n && a[j] - a[i] <= mid)
                j++;
            res += j - i - 1;
        }
        return res < k;
    }

    public static void main(String[] args) throws Exception {
        L719 obj = new L719();
    }
}
