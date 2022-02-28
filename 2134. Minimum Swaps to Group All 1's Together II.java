class L2134 {
    public int minSwaps(int[] nums) {
        int count_1 = 0;
        int n = nums.length;

        if (n == 1)
            return 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                count_1++;
        }

        int windowsize = count_1;
        count_1 = 0;

        for (int i = 0; i < windowsize; i++) {
            if (nums[i] == 1)
                count_1++;
        }

        int mx = count_1;
        for (int i = windowsize; i < n + windowsize; i++) {
            if (nums[i % n] == 1)
                count_1++;
            if (nums[(i - windowsize) % n] == 1)
                count_1--;
            mx = Math.max(count_1, mx);
        }
        return windowsize - mx;
    }
}
