import java.util.*;

class SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        return solve(root.left, root.right);
    }

    public boolean solve(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (same(left, right)) {
            queue.add(left);
            queue.add(right);
        } else
            return false;
        while (!queue.isEmpty()) {
            TreeNode firstChoice = queue.poll();
            TreeNode secondChoice = queue.poll();
            if (firstChoice == null && secondChoice == null)
                continue;
            if (!same(firstChoice, secondChoice))
                return false;
            queue.add(firstChoice.left);
            queue.add(secondChoice.right);
            queue.add(firstChoice.right);
            queue.add(secondChoice.left);
        }
        return true;
    }

    private boolean same(TreeNode first, TreeNode second) {
        if (first == null && second == null)
            return true;
        if (first == null || second == null)
            return false;
        if (first.val != second.val)
            return false;
        else
            return true;
    }
}
