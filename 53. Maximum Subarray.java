class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int local = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }
}
