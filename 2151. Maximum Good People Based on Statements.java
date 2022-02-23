import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Main2151 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int maximumGood(int[][] statements) {
        int result = 0;
        int n = (1 << statements.length) - 1;

        for (int mask = 1; mask <= n; mask++) {
            if (isValid(statements, mask)) {
                result = Math.max(result, Integer.bitCount(mask));
            }
        }

        return result;
    }

    private boolean isValid(int[][] statements, int mask) {
        for (int i = 0; i < statements.length; i++) {
            if (((1 << i) & mask) == 0) {
                continue;
            }
            for (int j = 0; j < statements[i].length; j++) {
                if (statements[i][j] == 2)
                    continue;
                if ((statements[i][j] == 0 && ((1 << j) & mask) != 0)
                        || (statements[i][j] == 1 && ((1 << j) & mask) == 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    void solve(int TC) throws Exception {
        System.out.println(maximumGood(new int[][] { { 2, 1, 0, 2, 0, 0, 1, 2, 2, 1, 2, 2, 1, 0, 0 },
                { 1, 2, 0, 0, 2, 0, 1, 2, 0, 2, 2, 2, 1, 0, 0 }, { 2, 2, 2, 1, 1, 0, 2, 1, 2, 0, 1, 2, 0, 1, 1 },
                { 0, 0, 1, 2, 1, 0, 2, 1, 2, 0, 1, 1, 0, 2, 1 }, { 2, 0, 1, 2, 2, 0, 2, 1, 1, 2, 1, 2, 0, 1, 1 },
                { 2, 0, 0, 0, 0, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2 }, { 1, 2, 0, 2, 2, 2, 2, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 1, 0, 1, 1 }, { 2, 2, 2, 1, 1, 0, 0, 2, 2, 0, 1, 1, 0, 1, 1 },
                { 1, 1, 2, 2, 0, 0, 1, 0, 2, 2, 2, 2, 2, 2, 2 }, { 0, 0, 1, 1, 1, 0, 0, 1, 1, 2, 2, 1, 2, 1, 1 },
                { 2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 2, 2, 1, 1 }, { 1, 1, 0, 0, 2, 2, 1, 2, 2, 1, 0, 0, 2, 2, 2 },
                { 2, 0, 2, 1, 2, 2, 0, 1, 1, 2, 1, 1, 2, 2, 1 }, { 0, 2, 1, 1, 1, 2, 0, 1, 1, 2, 1, 2, 0, 1, 2 } }));
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
            new Main2151().run();
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
