import java.util.*;

import random.Pair;
import random.TreeNode;

class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Pair<Integer, Integer>> priority = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        int[] sum = new int[k];
        for (int key : map.keySet()) {
            priority.add(new Pair<Integer, Integer>(key, map.get(key)));
            if (priority.size() > k) {
                priority.poll();
            }

        }
        for (int i = 0; i < k; i++) {
            sum[i] = priority.poll().getKey();
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        L347 obj = new L347();
    }
}
