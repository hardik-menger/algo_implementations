class HouseRobber {
    public int robdp(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }

    public int rob(int[] nums) {
        int prev = 0;
        int next = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = next;
            next = Math.max(prev + nums[i], next);
            prev = temp;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[] { 1, 2, 3, 1 }));
    }
}
