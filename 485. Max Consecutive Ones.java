class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int half = 0;
        int full = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                half++;
            else
                half = 0;
            if (half > full)
                full = half;
        }
        return full;
    }
}
