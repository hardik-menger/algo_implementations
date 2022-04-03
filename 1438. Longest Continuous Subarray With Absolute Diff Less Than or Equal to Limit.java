import java.util.*;

class L1438 {
    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>(), minQ = new ArrayDeque<>();
        int left = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[i])
                maxQ.pollLast();
            while (!minQ.isEmpty() && minQ.peekLast() > nums[i])
                minQ.pollLast();
            minQ.add(nums[i]);
            maxQ.add(nums[i]);
            if (maxQ.peek() - minQ.peek() > limit) {
                if (nums[left] == maxQ.peek())
                    maxQ.poll();
                if (nums[left] == minQ.peek())
                    minQ.poll();
                left++;
            }
        }
        return i - left;
    }

    public static void main(String[] args) throws Exception {
        L1438 obj = new L1438();
    }
}
