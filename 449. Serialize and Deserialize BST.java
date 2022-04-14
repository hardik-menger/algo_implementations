import java.util.*;
import java.util.stream.Collectors;

class L449 {
    public class Codec {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder(root, sb);
            return sb.toString();
        }

        private void preorder(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;
            sb.append(root.val).append(',');
            preorder(root.left, sb);
            preorder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0)
                return null;
            Deque<Integer> deque = new ArrayDeque<Integer>(Arrays.asList(data.split(",")).stream()
                    .mapToInt(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
            return verify(deque, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode verify(Deque<Integer> deque, int minValue, int maxValue) {
            if (!deque.isEmpty() && minValue < deque.peekFirst() && maxValue > deque.peekFirst()) {
                int value = deque.pollFirst();
                TreeNode node = new TreeNode(value);
                node.left = (verify(deque, minValue, value));
                node.right = (verify(deque, value, maxValue));
                return node;
            }
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        L449 obj = new L449();
    }
}
