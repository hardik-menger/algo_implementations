import java.util.Stack;

class TrappingRainWater {
    public int trap1(int[] height) {
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

    public int trap(int[] height) {
        int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0;
        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= leftMax)
                    leftMax = height[l];
                else
                    ans += (leftMax - height[l]);
                l++;
            } else {
                if (height[r] >= rightMax)
                    rightMax = height[r];
                else
                    ans += (rightMax - height[r]);
                r--;
            }
        }
        return ans;
    }
}
