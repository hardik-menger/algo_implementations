import java.util.*;

class L988 {

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

    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            if (ans == null)
                ans = sb.reverse().toString();
            else {
                sb.reverse();
                String newValue = sb.toString();
                if (ans.compareTo(newValue) > 0)
                    ans = newValue;
                sb.reverse();
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) throws Exception {
        L988 obj = new L988();
    }
}
