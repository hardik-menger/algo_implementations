import java.util.*;

import java.io.*;

class Main {

    class Pair<T, Q, R> {
        T p1;
        Q p2;
        R p3;

        Pair() {
            // default constructor
        }

        Pair(T a, Q b, R c) {
            this.p1 = a;
            this.p2 = b;
            this.p3 = c;
        }

        void setValue(T a, Q b, R c) {
            this.p1 = a;
            this.p2 = b;
            this.p3 = c;
        }

        Pair<T, Q, R> getValue() {
            return this;
        }

        @Override
        public String toString() {
            return "Pair(" + p1 + ", " + p2 + ", " + p3 + ")";
        }

    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int minFallingPathSum1(int[][] matrix) {
        if (matrix.length == 1)
            return matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            Stack<Pair<Integer, Integer, Integer>> stack = new Stack<>();
            stack.push(new Pair<Integer, Integer, Integer>(0, i, matrix[0][i]));
            res = Math.min(res, dfs(matrix, stack, 1, i));
        }
        return res;
    }

    int res = Integer.MAX_VALUE;

    private int dfs(int[][] matrix, Stack<Pair<Integer, Integer, Integer>> stack, int i, int j) {
        int[][] dirs = new int[][] { { 1, 1 }, { 1, 0 }, { 1, -1 } };

        while (!stack.isEmpty()) {
            Pair<Integer, Integer, Integer> top = stack.pop();
            for (int[] dir : dirs) {
                int newI = top.p1 + dir[0], newJ = top.p2 + dir[1];
                if (newI >= 0 && newJ >= 0 && newI < matrix.length && newJ < matrix.length) {
                    stack.push(new Pair<Integer, Integer, Integer>(newI, newJ, top.p3 + matrix[newI][newJ]));
                    if (newI == matrix.length - 1 && newJ <= matrix.length) {
                        res = Math.min(res, stack.peek().p3);
                    }
                }
            }
        }
        return res;
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1)
            return matrix[0][0];
        int res = Integer.MAX_VALUE;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(res, recursive(matrix, hm, 0, i));
        }
        return res;
    }

    private int recursive(int[][] matrix, HashMap<String, Integer> hm, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length)
            return Integer.MAX_VALUE;
        if (i == matrix.length - 1)
            return matrix[i][j];
        String key = i + ":" + j;
        if (hm.containsKey(key))
            return hm.get(key);
        int result = matrix[i][j] + Math
                .min(Math.min(recursive(matrix, hm, i + 1, j), recursive(matrix, hm, i + 1, j + 1)),
                        recursive(matrix, hm, i + 1, j - 1));
        hm.put(key, result);
        return result;
    }

    void solve(int TC) throws Exception {
        System.out.println(minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
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
            new Main().run();
        } catch (Exception e) {
            e.printStackTrace();
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
