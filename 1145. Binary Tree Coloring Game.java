import java.util.*;

class L1145 {

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

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        if (leftCount > n / 2 || rightCount > n / 2)
            return true;
        if (n - leftCount - rightCount - 1 > n / 2)
            return true;
        return false;
    }

    int leftCount = 0;
    int rightCount = 0;

    int count(TreeNode root, int x) {
        if (root == null)
            return 0;
        int left = count(root.left, x);
        int right = count(root.right, x);
        if (root.val == x) {
            leftCount = left;
            rightCount = right;
        }
        return left + right + 1;
    }

    public static void main(String[] args) throws Exception {
        L1145 obj = new L1145();
    }
}
