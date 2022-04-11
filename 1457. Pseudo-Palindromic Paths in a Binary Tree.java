import java.util.*;

class L1457 {

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

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, new BitSet(10));
    }

    private int dfs(TreeNode root, BitSet bitSet) {
        if (root == null)
            return 0;
        bitSet.flip(root.val);
        int ans = dfs(root.left, bitSet) + dfs(root.right, bitSet);
        if (root.left == root.right && root.right == null && bitSet.cardinality() <= 1)
            ans++;
        bitSet.flip(root.val);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L1457 obj = new L1457();
    }
}
