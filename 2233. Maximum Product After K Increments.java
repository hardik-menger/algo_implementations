import java.util.*;

class L2233 {

    public int maximumProduct(int[] nums, int k) {
        int n = nums.length;
        long mod = 1000000007;
        if (n == 1) {
            long ans = (nums[0] + k) % mod;
            return (int) ans;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int a : nums)
            pq.add((long) a);

        while (k > 0) {
            long first = pq.poll();
            long second = pq.peek();
            long diff = Math.min(k, second - first + 1);
            first += diff;
            k -= diff;
            pq.add(first);
        }
        long ans = 1;
        while (!pq.isEmpty()) {
            ans = (ans * pq.poll()) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) throws Exception {
        L2233 obj = new L2233();
    }
}
