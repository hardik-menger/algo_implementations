import java.util.*;

class L1004 {

    public int longestOnes(int[] nums, int k) {
        int i = 0, res = 0, zeros = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0)
                zeros++;
            else if (k < zeros) {
                if (nums[i] == 0)
                    zeros--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        L1004 obj = new L1004();
    }
}
