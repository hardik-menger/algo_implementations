package CSES;

import java.util.*;
import java.io.*;

class CoinChange {

    static long M = 1000000007;

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

    // min coins
    public static int minCoins(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - S[j] >= 0 && dp[i - S[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - S[j]] + 1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    // min ways
    public static int minWays(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++) {
                dp[j] = (int) ((dp[j] + dp[j - S[i]]));
                if (dp[j] > M)
                    dp[j] -= M;
            }
        return dp[n];
    }

    // total ways
    public static int totalWays(int S[], int m, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++)
            for (int i = 0; i < m; i++) {
                if (S[i] > j)
                    continue;
                dp[j] += dp[j - S[i]];
                if (dp[j] >= M)
                    dp[j] -= M;
            }
        return dp[n];
    }

    // min
    public static int minCoins2(int coins[], int sum) {
        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][sum + 1];

        // Initialising first row with +ve infinity
        for (int j = 0; j <= sum; j++) {
            arr[0][j] = Double.POSITIVE_INFINITY;
        }

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            arr[i][0] = 0;
        }

        // Implementing the recursive solution
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j)
                    arr[i][j] = Math.min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }

        return (int) arr[totalCoins][sum];
    }

    // min ways
    public static int minWays2(int coins[], int sum) {
        int arr[][] = new int[coins.length + 1][sum + 1];
        int totalCoins = coins.length;
        // Initialising first column with 0
        for (int i = 0; i <= totalCoins; i++) {
            arr[i][0] = 1;
        }

        // Implementing the recursive solution
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {
                arr[i][j] = (int) (arr[i - 1][j] % M);
                if (coins[i - 1] <= j)
                    arr[i][j] += arr[i][j - coins[i - 1]] % M;
            }
        }

        return arr[totalCoins][sum];
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        int m = ni();
        int n = ni();
        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = ni();
        }
        // pn(minWays(a, m, n));
        pn(totalWays2(a, n));
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
