class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int full = Integer.MIN_VALUE;
        int half = 0;
        for (int i : nums) {
            half += i;
            if (half > full)
                full = half;
            if (half < 0)
                half = 0;
        }
        return full;
    }
}
