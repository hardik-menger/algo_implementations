import java.util.*;

import random.Pair;
import random.TreeNode;

class L215 {

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        k = nums.length - k;
        while (l <= r) {
            int partition = partition(nums, l, r);
            if (partition == k) {
                return nums[partition];
            } else if (partition < k) {
                l = partition + 1;
            } else {
                r = partition - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = r;
        int j = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] < nums[r]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;
        return j;
    }

    public static void main(String[] args) throws Exception {
        L215 obj = new L215();
    }
}
