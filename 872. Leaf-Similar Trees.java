import java.util.*;

class L872 {

    public boolean leafSimilar(TreeNode root1,
            TreeNode root2) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack1.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (dfs(stack1) != dfs(stack2))
                return false;
        }

        return true;
    }

    private int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
            if (node.left == null && node.right == null)
                return node.val;
        }
    }

    public static void main(String[] args) throws Exception {
        L872 obj = new L872();
    }
}
