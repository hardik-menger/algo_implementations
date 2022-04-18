import java.util.*;

import random.Pair;
import random.TreeNode;

class L865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return recursive(root).p1;
    }

    Pair<TreeNode, Integer> recursive(TreeNode root) {
        if (root == null)
            return new Pair<>(null, 0);
        Pair<TreeNode, Integer> left = recursive(root.left);
        Pair<TreeNode, Integer> right = recursive(root.right);
        if (right.p2 == left.p2)
            return new Pair<>(root, right.p2 + 1);
        else if (right.p2 > left.p2)
            return new Pair<>(right.p1, right.p2 + 1);
        else
            return new Pair<>(left.p1, left.p2 + 1);
    }

    public static void main(String[] args) throws Exception {
        L865 obj = new L865();
    }
}
