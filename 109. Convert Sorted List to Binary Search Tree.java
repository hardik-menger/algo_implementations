
class SortedListtoBinarySearchTree {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public class TreeNode {
        int val, height = 1;
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

        int height(TreeNode N) {
            if (N == null)
                return 0;
            return N.height;
        }
    }

    private ListNode head;

    public TreeNode sortedListToBST(ListNode root) {
        int len = getLength(root);
        this.head = root;
        return solve(len);
    }

    private TreeNode solve(int length) {
        if (length <= 0)
            return null;
        TreeNode left = solve(length / 2);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        this.head = this.head.next;
        root.right = solve(length - 1 - length / 2);
        return root;
    }

    private int getLength(ListNode root) {
        int c = 0;
        ListNode temp = root;
        while (temp != null) {
            temp = temp.next;
            c = c + 1;
        }
        return c;
    }

}
