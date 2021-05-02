class DiameterofBinaryTree {

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

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameterOfBinaryTree1(root.left);
        int rdiameter = diameterOfBinaryTree1(root.right);
        return Math.max(lheight + rheight, Math.max(ldiameter, rdiameter));
    }

    static int height(TreeNode node) {
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public class Height {
        int height;
    }

    public int diameterOfBinaryTree(TreeNode root, Height height) {
        Height lh = new Height(), rh = new Height();
        if (root == null)
            return 0;
        int ldiameter = diameterOfBinaryTree(root.left, lh);
        int rdiameter = diameterOfBinaryTree(root.right, rh);
        height.height = Math.max(lh.height, rh.height) + 1;
        return Math.max(lh.height + rh.height, Math.max(ldiameter, rdiameter));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTree(root, new Height());
    }
}
