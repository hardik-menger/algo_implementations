import java.util.*;

class L802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, colors, i))
                al.add(i);
        }
        return al;
    }

    private boolean dfs(int[][] graph, int[] colors, int i) {
        if (colors[i] > 0)
            return colors[i] == 2;
        int connections[] = graph[i];
        if (colors[i] > 0)
            return colors[i] == 2;
        colors[i] = 1;
        for (int child : connections) {
            if (colors[child] == 2)
                continue;
            if (colors[child] == 1)
                return false;
            if (!dfs(graph, colors, child))
                return false;
        }
        colors[i] = 2;
        return true;
    }

    public static void main(String[] args) throws Exception {
        L802 obj = new L802();
    }
}
