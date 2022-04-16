import java.util.*;
import random.TreeNode;

class L1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> to_delete_set = new HashSet<Integer>();
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i : to_delete)
            to_delete_set.add(i);
        helper(root, result, to_delete_set, true);
        return result;
    }

    private TreeNode helper(TreeNode root, List<TreeNode> result, Set<Integer> to_delete_set, boolean isRoot) {
        if (root == null)
            return null;
        boolean toBeDelete = to_delete_set.contains(root.val);
        if (isRoot && !toBeDelete)
            result.add(root);
        root.left = helper(root.left, result, to_delete_set, toBeDelete);
        root.right = helper(root.right, result, to_delete_set, toBeDelete);
        return toBeDelete ? null : root;
    }

    public static void main(String[] args) throws Exception {
        L1110 obj = new L1110();
    }
}
