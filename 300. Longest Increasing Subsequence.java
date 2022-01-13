import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class LongestIncreasingSubsequence {
    // recursive
    public int lengthOfLIS1(int[] nums) {
        return lengthUtil(nums, 0, Integer.MIN_VALUE);
    }

    public int lengthUtil(int[] nums, int start, int tempAns) {
        if (nums.length == start)
            return 0;
        int taken = 0;
        if (nums[start] > tempAns)
            taken = 1 + lengthUtil(nums, start + 1, nums[start]);
        int notTaken = lengthUtil(nums, start + 1, tempAns);
        return Math.max(taken, notTaken);
    }

    // dp
    public int lengthOfLIS2(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;

            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // binarysearch
    public int lengthOfLIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[length - 1]) {
                tail[length++] = nums[i];
            } else {
                int idx = Arrays.binarySearch(tail, 0, length - 1, nums[i]);
                if (idx < 0)
                    idx = -1 * idx - 1;
                tail[idx] = nums[i];
            }
        }
        return length;
    }

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>(nums.length);
        al.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = Collections.binarySearch(al, nums[i]);
            if (index < 0)
                index = ~index;
            if (index == al.size()) {
                al.add(nums[i]);
            } else
                al.set(index, nums[i]);
        }
        return al.size();
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS2(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS2(new int[] { 0, 1, 0, 3, 2, 3 }));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS2(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
    }
}
