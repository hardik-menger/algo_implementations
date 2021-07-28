import java.util.Stack;

//https://www.youtube.com/watch?v=zx5Sw9130L0
class LargestRectangleiHistogram {
    public int largestRectangleArea(int[] heights) {
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
}
