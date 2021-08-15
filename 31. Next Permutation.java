class NextPermutation {
    public void nextPermutation(int[] nums) {
        int ascendingPairIndex = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                ascendingPairIndex = i - 1;
                break;
            }
        }
        if (ascendingPairIndex >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[ascendingPairIndex]) {
                j--;
            }
            swap(nums, ascendingPairIndex, j);
        }
        reverse(nums, ascendingPairIndex + 1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
