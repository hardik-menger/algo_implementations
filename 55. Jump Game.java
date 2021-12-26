class JumpGame {

    public boolean canJump(int[] nums) {
        int finishline = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int end = nums[i] + i;
            if (end >= finishline)
                finishline = i;
        }
        return finishline == 0;
    }

    public boolean canJumpRec(int[] nums) {
        return recursive(nums, 0);
    }

    private boolean recursive(int[] nums, int i) {
        if (i >= nums.length - 1)
            return true;
        int end = nums[i] + i;
        for (int j = i + 1; j <= end; j++) {
            boolean found = recursive(nums, j);
            if (found)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(new JumpGame().canJump(new int[] { 3, 2, 1, 0, 4 }));
    }
}
