import java.util.*;
import random.*;

class L95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        if (start > end) {
            List<TreeNode> al = new ArrayList<>();
            al.add(null);
            return al;
        }
        ArrayList<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> all_left_subtrees = helper(start, i - 1);
            List<TreeNode> all_right_subtrees = helper(i + 1, end);
            for (TreeNode left : all_left_subtrees) {
                for (TreeNode right : all_right_subtrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        L95 obj = new L95();
    }
}
