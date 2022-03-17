import java.util.*;

class L2192 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> directChild = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            directChild.add(new ArrayList<>());
        }
        for (int[] e : edges)
            directChild.get(e[0]).add(e[1]);
        for (int i = 0; i < n; i++)
            dfs(i, i, ans, directChild);
        return ans;
    }

    private void dfs(int ancestor, int curr, List<List<Integer>> ans, List<List<Integer>> directChild) {
        for (int ch : directChild.get(curr)) {
            List<Integer> ancestors = ans.get(ch);
            if (ancestors.size() == 0 || ancestors.get(ancestors.size() - 1) != ancestor) {
                ancestors.add(ancestor);
                dfs(ancestor, ch, ans, directChild);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        L2192 obj = new L2192();
    }
}
