
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

    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        return null;
    }

    class Avl {
        private int height(TreeNode N) {
            if (N == null)
                return 0;
            return N.height;
        }

        TreeNode insert(TreeNode node, int val) {
            if (node == null)
                return new TreeNode(val);
            if (node.val > val)
                node.left = insert(node.left, val);
            else
                node.right = insert(node.right, val);
            node.height = Math.max(node.right.height, node.left.height) + 1;
            int balance = getBalance(node);
            // Left Left Case
            if (balance > 1 && val < node.left.val)
                return rightRotate(node);

            // Right Right Case
            if (balance < -1 && val > node.right.val)
                return leftRotate(node);

            // Left Right Case
            if (balance > 1 && val > node.left.val) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Left Case
            if (balance < -1 && val < node.right.val) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            return node;
        }

        private SortedListtoBinarySearchTree.TreeNode leftRotate(SortedListtoBinarySearchTree.TreeNode node) {
            return null;
        }

        private SortedListtoBinarySearchTree.TreeNode rightRotate(SortedListtoBinarySearchTree.TreeNode node) {
            return null;
        }

        private int getBalance(TreeNode node) {
            if (node == null)
                return 0;
            else
                return height(node.left) - height(node.right);
        }
    }
}
