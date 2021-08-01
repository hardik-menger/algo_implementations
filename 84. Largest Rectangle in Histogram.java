import java.util.Stack;

//https://www.youtube.com/watch?v=zx5Sw9130L0
class LargestRectangleiHistogram {
    public int largestRectangleArea1(int[] heights) {
        class Pair<T, Q> {
            T p1;
            Q p2;

            Pair(T a, Q b) {
                this.p1 = a;
                this.p2 = b;
            }
        }
        Stack<Pair<Integer, Integer>> st = new Stack<Pair<Integer, Integer>>();
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int current = i;
            while (!st.empty() && st.peek().p2 > heights[i]) {
                Pair<Integer, Integer> before = st.pop();
                int height = before.p2, index = before.p1;
                maxarea = Math.max(maxarea, height * (i - index));
                current = index;
            }
            st.push(new Pair<Integer, Integer>(current, heights[i]));
        }
        while (!st.empty()) {
            Pair<Integer, Integer> item = st.pop();
            int height = item.p2, index = item.p1;
            maxarea = Math.max(maxarea, height * (heights.length - index));
        }
        return maxarea;

    }

    public int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] lessFromLeft = new int[height.length], lessFromRight = new int[height.length];
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i])
                p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0, i = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (i < height.length) {
            if (st.empty() || height[st.peek()] <= height[i])
                st.push(i++);
            else {
                int currentbartocalculate = st.pop();
                int left = st.peek();
                int localans = height[currentbartocalculate] * (st.empty() ? i : i - left - 1);
                if (localans > maxArea)
                    maxArea = localans;
            }
        }
        while (st.empty() == false) {
            int currentbartocalculate = st.pop();
            int localans = height[currentbartocalculate] * (st.empty() ? i : i - st.peek() - 1);

            if (localans > maxArea)
                maxArea = localans;
        }
        return maxArea;
    }
}
