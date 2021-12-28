class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int local = 0, global = nums[0];
        for (int i = 0; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { 1, -2, 3, -2 }));
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { 5, -3, 5 }));
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { -3, -2, -3 }));
    }
}
