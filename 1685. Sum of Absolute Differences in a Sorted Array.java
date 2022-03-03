import java.util.*;

class L1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int prefixSum[] = new int[n];
        int suffixSums[] = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] += (prefixSum[i - 1] + nums[i]);
        suffixSums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffixSums[i] += (suffixSums[i + 1] + nums[i]);
        int result[] = new int[n];
        for (int i = 1; i < n - 1; i++) {
            int left = Math.abs((i * nums[i]) - prefixSum[i - 1]);
            int right = Math.abs(((n - i - 1) * nums[i]) - suffixSums[i + 1]);
            result[i] = left + right;
        }
        result[0] = Math.abs(((n - 1) * nums[0]) - suffixSums[1]);
        result[n - 1] = Math.abs(((n - 1) * nums[n - 1]) - prefixSum[n - 2]);
        return result;
    }

    public static void main(String[] args) throws Exception {
        L1685 obj = new L1685();
        System.out.println(Arrays.toString(obj.getSumAbsoluteDifferences(new int[] { 2, 3, 5 })));
        System.out.println(Arrays.toString(obj.getSumAbsoluteDifferences(new int[] { 1, 4, 6, 8, 10 })));

    }
}
