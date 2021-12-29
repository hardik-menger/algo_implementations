class MaximumLengthofSubarrayWithPositiveProduct {
    public int getMaxLen1(int[] nums) {
        int negativelength = 0, positivelength = 0, ans = 0;
        for (int num : nums) {
            if (num > 0) {
                positivelength++;
                negativelength = negativelength == 0 ? 0 : negativelength + 1;
            } else if (num < 0) {
                int t = positivelength;
                positivelength = negativelength == 0 ? 0 : negativelength + 1;
                negativelength = t + 1;
            } else {
                negativelength = positivelength = 0;
            }
            ans = Math.max(ans, positivelength);
        }
        return ans;
    }

    public int getMaxLen(int[] nums) {
        int firstNeg = -1, firstZero = -1, numberOfNegativePositions = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                if (firstNeg == -1)
                    firstNeg = i;
                numberOfNegativePositions++;
            }
            if (num == 0) {
                firstZero = i;
                numberOfNegativePositions = 0;
                firstNeg = -1;
            }

            if (numberOfNegativePositions % 2 == 0)
                ans = Math.max(ans, i - firstZero);
            else
                ans = Math.max(ans, i - firstNeg);
        }
        return ans;
    }

}
