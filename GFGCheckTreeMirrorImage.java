import java.util.Stack;

public class GFGCheckTreeMirrorImage {
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

    static String areMirrors(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return "yes";
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        while (true) {
            while (root1 != null && root2 != null) {
                stack.push(root1);
                stack.push(root2);
                if (root1.val != root2.val)
                    return "no";
                root1 = root1.left;
                root2 = root2.right;
            }
            if (!(root1 == null && root2 == null))
                return "no";
            if (!stack.isEmpty() && !stack2.isEmpty()) {
                root1 = stack.pop();
                root2 = stack2.pop();
                root1 = root1.right;
                root2 = root2.left;
            } else
                break;
        }
        return "yes";
    }
}
