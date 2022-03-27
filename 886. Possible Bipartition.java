import java.util.*;

class L886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();
        for (int dislike[] : dislikes) {
            list.putIfAbsent(dislike[0], new ArrayList<>());
            list.putIfAbsent(dislike[1], new ArrayList<>());
            list.get(dislike[0]).add(dislike[1]);
            list.get(dislike[1]).add(dislike[0]);
        }
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i : list.keySet()) {
            if (colors[i] == -1 && !bfsCheck(list, colors, i))
                return false;
        }

        return true;
    }

    private boolean bfsCheck(HashMap<Integer, ArrayList<Integer>> list, int[] colors, int i) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        colors[i] = 1;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> neighbours = list.get(parent);
            for (int neighbour : neighbours) {
                if (colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[parent];
                    queue.add(neighbour);
                } else if (colors[neighbour] == colors[parent])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        colors[i] = 1;
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !bfsCheck(graph, colors, i))
                return false;
        }

        return true;
    }

    private boolean bfsCheck(int[][] graph, int[] colors, int i) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            int[] neighbours = graph[parent];
            for (int neighbour : neighbours) {
                if (colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[parent];
                    queue.add(neighbour);
                } else if (colors[neighbour] == colors[parent])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        L886 obj = new L886();
    }
}
