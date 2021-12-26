class HouseRobberII {

    public int rob1(int[] nums, int l, int r) {
        int prev = 0;
        int next = nums[l];
        for (int i = l + 1; i <= r; i++) {
            int temp = next;
            next = Math.max(prev + nums[i], next);
            prev = temp;
        }
        return next;
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[] { 1, 2, 3, 1 }));
    }
}
