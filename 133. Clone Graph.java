import java.util.*;

class L133 {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        HashMap<Integer, Node> neighbors = new HashMap<Integer, Node>();
        if (node == null)
            return null;
        Node newRoot = new Node(node.val);
        neighbors.put(node.val, newRoot);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node ele = queue.poll();
            for (Node neighbor : ele.neighbors) {
                if (!neighbors.containsKey(neighbor.val)) {
                    neighbors.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                neighbors.get(ele.val).neighbors.add(neighbors.get(neighbor.val));
            }
        }
        return newRoot;
    }

    public static void main(String[] args) throws Exception {
        L133 obj = new L133();
        Node a = new Node(1, null);
        // a.neighbors.add(new Node(2));
        System.out.println(obj.cloneGraph(a).val);
    }
}
