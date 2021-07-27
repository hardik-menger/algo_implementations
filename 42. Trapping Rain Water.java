import java.util.Stack;

class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        for (int current = 0; current < height.length; current++) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty())
                    break;
                int dist = current - st.peek() - 1;
                int gapanswer = Math.min(height[st.peek()], height[current]) - height[top];
                ans += dist * gapanswer;
            }
            st.add(current);
        }
        return ans;
    }
}
