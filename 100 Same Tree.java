import java.util.*;

class EqualTrees {
    class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (same(p, q)) {
            queue.add(p);
            queue.add(q);
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
            queue.add(secondChoice.left);
            queue.add(firstChoice.right);
            queue.add(secondChoice.right);
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