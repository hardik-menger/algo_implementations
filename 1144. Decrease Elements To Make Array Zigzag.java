import java.util.*;

class L1144 {
    public int movesToMakeZigzag(int[] nums) {
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1];
            res[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }

    public static void main(String[] args) throws Exception {
        L1144 obj = new L1144();
        System.out.println(obj.movesToMakeZigzag(new int[] { 1, 2, 3 }));
        System.out.println(obj.movesToMakeZigzag(new int[] { 9, 6, 1, 6, 2 }));
    }
}
