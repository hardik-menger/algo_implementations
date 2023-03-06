class MaximumProductSubarray {

    // modification of kadanes
    // https://www.youtube.com/watch?v=a29nhnBEjpw
    public int maxProduct(int[] nums) {
        int min_so_far = nums[0], max_so_far = nums[0],
                prev_max_so_far = nums[0], prev_min_so_far = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min_so_far = Math.min(Math.min(prev_min_so_far * nums[i], prev_max_so_far * nums[i]), nums[i]);
            max_so_far = Math.max(Math.max(prev_min_so_far * nums[i], prev_max_so_far * nums[i]), nums[i]);
            prev_max_so_far = max_so_far;
            prev_min_so_far = min_so_far;
            ans = Math.max(ans, Math.max(max_so_far, min_so_far));
        }
        return ans;
    }
}
