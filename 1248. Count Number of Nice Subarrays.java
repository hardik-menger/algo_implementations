import java.util.*;

class L1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int i = 0, count = 0;
        for (int j = 0; j < nums.length; j++) {
            k -= nums[j] % 2;
            while (k < 0)
                k += nums[i++] % 2;
            count += (j - i + 1);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L1248 obj = new L1248();
    }
}
