import java.util.*;
import random.*;

class L1192 {
    boolean[] inStack;
    int[] tin;
    int[] min;
    int timer;
    ArrayList<ArrayList<Integer>> adj;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> connection : connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }
        tin = new int[n];
        min = new int[n];
        Arrays.fill(tin, -1);
        timer = 0;
        dfs(connections.get(0).get(0), -1, result);
        return result;
    }

    private void dfs(int node, int parent, List<List<Integer>> result) {
        tin[node] = min[node] = timer;
        timer++;
        for (int connection : adj.get(node)) {
            if (connection == parent)
                continue;
            if (tin[connection] == -1) {
                dfs(connection, node, result);
                min[node] = Math.min(min[node], min[connection]);
                if (tin[node] < min[connection])
                    result.add(List.of(node, connection));
            } else
                min[node] = Math.min(min[node], min[connection]);
        }
    }

    public static void main(String[] args) throws Exception {
        L1192 obj = new L1192();
    }
}
