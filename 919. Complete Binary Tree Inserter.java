import java.util.*;
import random.*;

class L919 {
    class CBTInserter {
        Queue<TreeNode> children = new LinkedList<>();
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode ele = q.poll();
                if (ele.left != null && ele.right == null)
                    children.add(ele);
                else if (ele.left == null || ele.right == null)
                    children.add(ele);
                if (ele.left != null)
                    q.add(ele.left);
                if (ele.right != null)
                    q.add(ele.right);
            }
        }

        public int insert(int val) {
            TreeNode ele = children.peek();
            TreeNode newNode = new TreeNode(val);
            if (ele.left != null && ele.right == null) {
                ele.right = newNode;
                children.poll();
            } else
                ele.left = newNode;
            children.add(newNode);
            return ele.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static void main(String[] args) throws Exception {
        L919 obj = new L919();
    }
}
