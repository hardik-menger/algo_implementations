package CodingNinjas;

import java.util.*;
import java.io.*;

class Mainrodcuttingproblem {

    public static int cutRod1(int price[], int n) {
        return recursive(n - 1, n, price);
    }

    private static int recursive(int i, int n, int[] price) {
        if (i == 0) {
            return price[0] * n;
        }
        int nottake = recursive(i - 1, n, price);
        int take = Integer.MIN_VALUE;
        if (n >= i + 1)
            take = price[i] + recursive(i, n - (i + 1), price);
        return Math.max(take, nottake);
    }

    public static int cutRod2(int price[], int target) {
        int dp[][] = new int[target][target + 1];
        for (int i = 0; i <= target; i++)
            dp[0][i] = i * price[0];
        for (int index = 1; index < target; index++) {
            for (int N = 0; N <= target; N++) {
                int nottake = dp[index - 1][N];
                int take = Integer.MIN_VALUE;
                if (N >= index + 1)
                    take = price[index] + dp[index][N - (index + 1)];
                dp[index][N] = Math.max(take, nottake);
            }
        }
        return dp[target - 1][target];
    }

    public static int cutRod(int price[], int target) {
        int dp[] = new int[target + 1];
        for (int i = 0; i <= target; i++)
            dp[i] = i * price[0];
        for (int index = 1; index < target; index++) {
            for (int N = 0; N <= target; N++) {
                int nottake = dp[N];
                int take = Integer.MIN_VALUE;
                if (N >= index + 1)
                    take = price[index] + dp[N - (index + 1)];
                dp[N] = Math.max(take, nottake);
            }
        }
        return dp[target];
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        int n = 5;
        int s[] = new int[] { 2, 5, 7, 8, 10 };
        System.out.println(cutRod(s, n));
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
            new Mainrodcuttingproblem().run();
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
