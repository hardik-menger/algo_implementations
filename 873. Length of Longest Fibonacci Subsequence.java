import java.util.*;

class L873 {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++)
            index.put(arr[i], i);
        HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
        int n = arr.length;
        int ans = 0;
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    int candiate = history.getOrDefault(i * n + j, 2) + 1;
                    history.put(j * n + k, candiate);
                    ans = Math.max(ans, candiate);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) throws Exception {
        L873 obj = new L873();
    }
}
