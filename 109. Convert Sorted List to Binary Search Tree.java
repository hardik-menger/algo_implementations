import java.util.*;

class SortedListtoBinarySearchTree {

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

    private ListNode head;

    public TreeNode sortedListToBST(ListNode root) {
        int len = getLength(root);
        this.head = root;
        return convertListToBST(0, len - 1);
    }

    public void levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        if (root == null) {
            System.out.println("?");
            return;
        }
        while (true) {
            if (queue.isEmpty())
                break;
            int size = queue.size();
            ArrayList<Integer> rowres = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode firstChoice = queue.poll();
                if (firstChoice != null) {
                    rowres.add(firstChoice.val);
                    if (firstChoice.left != null)
                        queue.add(firstChoice.left);
                    if (firstChoice.right != null)
                        queue.add(firstChoice.right);
                }
                size--;

            }
            al.add(rowres);
        }
        for (List<Integer> a : al) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println(" ");

        }
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode left = this.convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        node.right = this.convertListToBST(mid + 1, r);
        return node;
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
