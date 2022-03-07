import java.util.*;

class L2190 {

    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> freq = new HashMap<>();
        int mostFreq = -1;
        for (int i = 0, n = nums.length, max = 0; i < n; ++i) {
            if (nums[i] == key && i + 1 < n) {
                int candidate = nums[i + 1];
                freq.put(candidate, 1 + freq.getOrDefault(candidate, 0));
                if (freq.get(candidate) > max) {
                    max = freq.get(candidate);
                    mostFreq = candidate;
                }
            }
        }
        return mostFreq;
    }

    public static void main(String[] args) throws Exception {
        L2190 obj = new L2190();
        System.out.println(obj.mostFrequent(new int[] { 1, 100, 200, 1, 100 }, 1));
    }
}
