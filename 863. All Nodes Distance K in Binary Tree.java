import java.util.*;
import random.*;
import random.TreeNode;

class L863 {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null || k < 0)
            return res;
        buildMap(root, null);
        if (!map.containsKey(target))
            return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (k == 0) {
                for (int i = 0; i < size; i++)
                    res.add(q.poll().val);
                return res;
            }
            while (size-- != 0) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next))
                        continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            k--;
        }
        return res;
    }

    private void buildMap(TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<TreeNode>());
            if (parent != null) {
                map.get(root).add(parent);
                map.get(parent).add(root);
            }
            buildMap(root.left, root);
            buildMap(root.right, root);
        }
    }

    public static void main(String[] args) throws Exception {
        L863 obj = new L863();
    }
}
