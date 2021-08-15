class MissingNumber {
    public int missingNumber1(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++)
            result ^= i ^ nums[i];
        return result;
    }
}