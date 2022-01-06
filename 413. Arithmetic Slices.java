class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int a = 0, ap = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                a++;
                ap += a;
            } else {
                a = 0;
            }
        }
        return ap;
    }
}