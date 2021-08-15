import java.util.*;

class MaximumWidthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        q.add(root);
        m.put(root, 1);
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            int currentLayerSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int currentLevel = m.get(node);
                if (i == 0)
                    start = currentLevel;
                if (i == size - 1)
                    end = currentLevel;
                if (node.left != null) {
                    q.add(node.left);
                    m.put(node.left, 2 * currentLevel);
                }
                if (node.right != null) {
                    q.add(node.right);
                    m.put(node.right, 2 * currentLevel + 1);
                }
            }
            currentLayerSize = end - start + 1;
            maxW = Math.max(maxW, currentLayerSize);
        }
        return maxW;
    }
}
