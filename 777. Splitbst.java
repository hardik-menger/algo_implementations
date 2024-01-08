import java.util.*;
import random.*;

class L777 {
    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<TreeNode<Integer>> splitBST(TreeNode<Integer> root, int val) {
        if (root == null) {
            var res = new ArrayList<TreeNode<Integer>>();
            res.add(null);
            res.add(null);
            return res;
        }

        if (root.data <= val) {
            ArrayList<TreeNode<Integer>> list = splitBST(root.right, val);
            root.right = list.get(0);
            list.set(0, root);
            list.set(1, list.get(1));
            return list;
        } else {
            ArrayList<TreeNode<Integer>> list = splitBST(root.left, val);
            root.left = list.get(1);
            list.set(0, list.get(0));
            list.set(1, root);
            return list;
        }
    }

    public static void main(String[] args) throws Exception {
        L777 obj = new L777();
    }
}
