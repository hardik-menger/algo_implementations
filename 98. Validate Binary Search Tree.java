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

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        solve(root, al);
        System.out.println(al);
        return isSorted(al);
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
