import java.util.*;

class L862 {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        long prefix[] = new longq[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            prefix[i + 1] += (prefix[i] + nums[i]);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length + 1; i++) {
            while (!dq.isEmpty() && (prefix[i] - prefix[dq.getFirst()] >= k))
                result = Math.min(result, i - dq.pollFirst());
            while (!dq.isEmpty() && prefix[dq.getLast()] >= prefix[i])
                dq.pollLast();
            dq.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) throws Exception {
        L862 obj = new L862();
    }
}
