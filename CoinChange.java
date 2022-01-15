import java.util.*;
import java.io.*;

class CoinChange {

    static long M = 1000000007;

    // min no of ways infinite
    static int count(int S[], int m, int n) {

        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
    }

    // min no of coins infinite
    static int minnoofcoinsinfinite(int S[], int target) {
        int n = S.length;
        int dp[] = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < n; i++) {
                if (S[i] <= j && dp[j - S[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - S[i]] + 1);
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

    // min no of ways infinite
    public int change(int n, int[] S) {
        int dp[] = new int[n + 1];
        int m = S.length;
        dp[0] = 1;
        for (int j = 0; j < m; j++)
            for (int i = 1; i <= n; i++)
                if (i >= S[j])
                    dp[i] += dp[i - S[j]];
        return dp[n];
    }

    void solve(int TC) throws Exception {
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
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        try {
            new CoinChange().run();
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
