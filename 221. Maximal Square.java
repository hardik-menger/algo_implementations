import java.util.*;
import java.io.*;

class Main221 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int maximalSquare1(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n + 1][m + 1], rowOnes[][] = new int[n + 1][m + 1], colOnes[][] = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                rowOnes[i][j] = matrix[i][j] == '1' ? rowOnes[i + 1][j] + 1 : 0;
                colOnes[i][j] = matrix[i][j] == '1' ? colOnes[i][j + 1] + 1 : 0;
            }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = matrix[i][j] == '1'
                        ? 1 + Math.min(Math.min(rowOnes[i][j] - 1, colOnes[i][j] - 1), dp[i + 1][j + 1])
                        : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        return ans * ans;
    }

    public int maximalSquare2(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = matrix[i][j] == '1'
                        ? 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i + 1][j + 1])
                        : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        return ans * ans;
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[2][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                dp[i & 1][j] = matrix[i][j] == '1'
                        ? 1 + Math.min(Math.min(dp[(i & 1)][j + 1], dp[(i + 1) & 1][j]), dp[((i + 1) & 1)][j + 1])
                        : 0;
                ans = Math.max(ans, dp[i & 1][j]);
            }
        return ans * ans;
    }

    void solve(int TC) throws Exception {
        char res[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' } };
        System.out.println(maximalSquare(res));
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
            new Main221().run();
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
