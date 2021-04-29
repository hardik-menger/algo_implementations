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
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int maxVal = 1;
        for (int i = 1; i < nums.length; i++) {
            int tempVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    tempVal = Math.max(tempVal, dp[j]);
            }
            dp[i] = tempVal + 1;
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

    // binarysearch
    public int lengthOfLIS(int[] nums) {
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
}
