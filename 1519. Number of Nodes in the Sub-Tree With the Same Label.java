import java.util.*;

class L1519 {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }
        int[] ans = new int[n];
        Set<Integer> seen = new HashSet<>();
        dfs(g, 0, labels, seen, ans);
        return ans;
    }

    private int[] dfs(Map<Integer, List<Integer>> g, int node, String labels, Set<Integer> seen, int[] ans) {
        int count[] = new int[26];
        if (seen.add(node)) {
            char c = labels.charAt(node);
            List<Integer> children = g.getOrDefault(node, Collections.emptyList());
            for (int childIndex = 0; childIndex < children.size(); childIndex++) {
                int sub[] = dfs(g, children.get(childIndex), labels, seen, ans);
                for (int i = 0; i < 26; i++) {
                    count[i] += sub[i];
                }
            }
            ++count[c - 'a'];
            ans[node] = count[c - 'a'];
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L1519 obj = new L1519();
    }
}
