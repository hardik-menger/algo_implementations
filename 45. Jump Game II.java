class JumpGameII {
    public int jump1(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int jumps[] = new int[nums.length];
        jumps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            jumps[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= (j + nums[j]) && jumps[j] != Integer.MIN_VALUE) {
                    jumps[i] = Math.max(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[nums.length - 1];
    }

    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int jumps = 1, steps = nums[0], staircaseStepsMerged = nums[0];
        for (int i = 1; i < nums.length; i++) {
            staircaseStepsMerged = Math.max(staircaseStepsMerged, i + nums[i]);
            if (i == nums.length - 1)
                return jumps;
            steps--;
            if (steps == 0) {
                steps = staircaseStepsMerged - i;
                jumps++;
            }
        }
        return jumps;
    }
}
