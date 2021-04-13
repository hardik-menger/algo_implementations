import java.util.*;

class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect1(Node root) {
        levelOrder(root);
        return root;
    }

    // fastest
    public Node connect(Node root) {
        if (root == null)
            return null;
        solve(root);
        return root;
    }

    void solve(Node root) {
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            solve(root.left);
            solve(root.right);
        }
    }

    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        if (root == null)
            return;
        while (true) {
            if (queue.isEmpty())
                break;
            int size = queue.size();
            Node prev = null;
            while (size > 0) {
                Node current = queue.poll();
                System.out.print(current.val + " ");
                if (current != null) {
                    if (prev != null) {
                        prev.next = queue.peek();
                    }
                    prev = current;
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
                size--;
            }
            System.out.println();

        }
    }
}
