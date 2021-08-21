class SumTreeGFG {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    boolean isSumTree(Node root) {
        if (root == null || isLeaf(root))
            return true;
        if (isSumTree(root.left) && isSumTree(root.right)) {
            int left = 0, right = 0;
            if (root.left == null)
                left = 0;
            else if (isLeaf(root.left))
                left = root.left.data;
            else
                left = 2 * root.left.data;
            if (root.right == null)
                right = 0;
            else if (isLeaf(root.right))
                right = root.right.data;
            else
                right = 2 * root.right.data;
            return (root.data == left + right);
        }
        return false;
    }

    boolean isLeaf(Node root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return true;
        return false;
    }
}