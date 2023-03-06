import java.util.*;
import random.*;

class L103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return new ArrayList<>(res);
        Deque<TreeNode> q = new ArrayDeque<>();
        boolean isfirst = true;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            if (isfirst) {
                while (size-- != 0) {
                    TreeNode node = q.pollFirst();
                    arr.add(node.val);
                    if (node.left != null)
                        q.addLast(node.left);
                    if (node.right != null)
                        q.addLast(node.right);

                }
                res.add(arr);
            } else {
                while (size-- != 0) {
                    TreeNode node = q.pollLast();
                    arr.add(node.val);
                    if (node.right != null)
                        q.addFirst(node.right);
                    if (node.left != null)
                        q.addFirst(node.left);

                }
                res.add(arr);

            }
            isfirst = !isfirst;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        L103 obj = new L103();
    }
}
