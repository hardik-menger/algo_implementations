import java.util.*;
import java.io.*;

class Main85 {

    class Pair<T, Q> {
        T p1;
        Q p2;

        Pair(T a, Q b) {
            this.p1 = a;
            this.p2 = b;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> st = new Stack<Pair<Integer, Integer>>();
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int current = i;
            while (!st.empty() && st.peek().p2 > heights[i]) {
                Pair<Integer, Integer> before = st.pop();
                int height = before.p2, index = before.p1;
                maxarea = Math.max(maxarea, height * (i - index));
                current = index;
            }
            st.push(new Pair<Integer, Integer>(current, heights[i]));
        }
        while (!st.empty()) {
            Pair<Integer, Integer> item = st.pop();
            int height = item.p2, index = item.p1;
            maxarea = Math.max(maxarea, height * (heights.length - index));
        }
        return maxarea;

    }

    public int maximalRectangle(char[][] matrix) {
        int[] row = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++)
            row[i] = (matrix[0][i]) - '0';
        int max = largestRectangleArea(row);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0')
                    row[j] = 0;
                else
                    row[j] += (matrix[i][j] - '0');
            }
            max = Math.max(max, largestRectangleArea(row));
        }
        return max;
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        System.out.println(maximalRectangle(new char[][] { { '0', '1' } }));
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
            new Main85().run();
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
