class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int localMax = 0, globalMax = nums[0], localMin = 0, globalMin = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, localMax);
            localMin = Math.min(localMin + nums[i], nums[i]);
            globalMin = Math.min(globalMin, localMin);
            sum += nums[i];
        }
        return globalMax > 0 ? Math.max(globalMax, sum - globalMin) : globalMax;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[] { 5, -3, 5 }));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[] { -3, -2, -3 }));
    }
}
