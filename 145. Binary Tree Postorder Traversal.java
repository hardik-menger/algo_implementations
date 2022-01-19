import java.util.*;
import java.io.*;

class Main145 {

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

    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        LinkedList<Integer> stack2 = new LinkedList<Integer>();
        if (root == null)
            return stack2;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.addLast(node.val);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }
        Collections.reverse(stack2);
        return stack2;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            } else {
                TreeNode node = stack.pop();
                root = node.left;
            }
        }
        return res;
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        int n = ni();
    }

    static boolean multipleTC = false;
    static FastReader in;
    static PrintWriter out;
    static Scanner sc;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        sc = new Scanner(System.in);
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        try {
            new Main145().run();
        } catch (Exception e) {

        }
    }

    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return in.nextInt();
    }

    long nl() throws Exception {
        return in.nextLong();
    }

    double nd() throws Exception {
        return in.nextDouble();
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
