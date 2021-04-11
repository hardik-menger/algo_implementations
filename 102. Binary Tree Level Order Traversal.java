import java.util.*;

class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        if (root == null)
            return al;
        while (true) {
            if (queue.isEmpty())
                break;
            int size = queue.size();
            ArrayList<Integer> rowres = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode firstChoice = queue.poll();
                if (firstChoice != null) {
                    rowres.add(firstChoice.val);
                    if (firstChoice.left != null)
                        queue.add(firstChoice.left);
                    if (firstChoice.right != null)
                        queue.add(firstChoice.right);
                }
                size--;

            }
            al.add(rowres);
        }
        return al;
    }
}
