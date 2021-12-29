class MaximumProductSubarray {
    public int maxProduct1(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            ans = Math.max(ans, Math.max(min, max));
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int maxProduct(int[] nums) {
        int l = 1, r = 1, ans = nums[0], n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (l == 0)
                l = 1;
            if (r == 0)
                r = 1;
            l *= nums[i];
            r *= nums[n - i];
            ans = Math.max(ans, Math.max(l, r));
        }
        return ans;
    }
}
