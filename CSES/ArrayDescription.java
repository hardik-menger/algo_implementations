import java.util.*;
import java.io.*;

class ArrayDescription {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    long M = 1000000007;

    void solve(int TC) throws Exception {
        int n = ni();
        int m = ni();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = ni();
        long dp[][] = new long[m + 1][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (a[i] == 0) {
                    for (int j = 1; j <= m; j++) {
                        dp[j][i] = 1;
                    }
                } else {
                    dp[a[i]][i] = 1;
                }
                continue;
            }
            if (a[i] != 0)
                dp[a[i]][i] = ((dp[a[i] - 1][i - 1]) % M + dp[a[i]][i - 1] % M
                        + ((a[i] + 1 <= m) ? dp[a[i] + 1][i - 1] % M : 0)) % M;
            else
                for (int j = 1; j <= m; j++) {
                    dp[j][i] = (dp[j - 1][i - 1] % M + dp[j][i - 1] % M + ((j + 1 <= m) ? dp[j + 1][i - 1] % M : 0))
                            % M;

                }
        }
        if (a[n - 1] != 0)
            pn(dp[a[n - 1]][n - 1] % M);
        else {
            long res = 0;
            for (int j = 1; j <= m; j++) {
                res += dp[j][n - 1];
            }
            pn(res % M);
        }

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
            new ArrayDescription().run();
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
