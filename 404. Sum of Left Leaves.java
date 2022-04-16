import java.util.*;

class L404 {

    public int sumOfLeftLeaves(GFGCheckTreeMirrorImage.TreeNode root) {
        return calculate(root, false);
    }

    int calculate(GFGCheckTreeMirrorImage.TreeNode root, boolean count) {
        if (root == null)
            return 0;
        if (count && root.left == null && root.right == null)
            return root.val;
        return calculate(root.left, true) + calculate(root.right, false);
    }

    public static void main(String[] args) throws Exception {
        L404 obj = new L404();
    }
}
