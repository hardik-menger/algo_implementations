import java.util.*;

class L992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0)
                K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0)
                    K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    // 2215. Find the Difference of Two Arrays
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        HashSet<Integer> a = new HashSet<>();
        for (int i : nums1)
            a.add(i);
        for (int i : nums2) {
            if (!a.contains(i) && !result.get(1).contains(i)) {
                result.get(1).add(i);
            }
        }
        a.clear();
        for (int i : nums2)
            a.add(i);
        for (int i : nums1) {
            if (!a.contains(i) && !result.get(0).contains(i)) {
                result.get(0).add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        L992 obj = new L992();
    }
}
