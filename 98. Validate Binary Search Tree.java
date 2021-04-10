import java.util.*;

class ValidateBinarySearchTree {
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

    int current = Integer.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        solve(root, al);
        System.out.println(al);
        return isSorted(al);
    }

    public boolean isValidBST(TreeNode root) {
        return solve2(root, root.left, root.right);
    }

    private boolean solve2(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return true;
        if (left != null && left.val >= root.val)
            return false;
        if (right != null && right.val <= root.val)
            return false;
        return solve2(root.left, left, root) && solve2(root.right, root, right);
    }

    private boolean isSorted(ArrayList<Integer> al) {
        for (int i = 0; i + 1 < al.size(); i++) {
            if (al.get(i) > al.get(i + 1))
                return false;
        }
        return true;
    }

    public void solve(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;
        solve(root.left, al);
        al.add(root.val);
        solve(root.right, al);
    }

}
