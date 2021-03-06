import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class MoneySums {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        int n = ni();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = ni();
        soln2(n, a);
    }

    private void soln2(int n, int[] a) {
        TreeSet<Integer> al = new TreeSet<Integer>();
        al.add(a[0]);
        for (int i = 1; i < n; i++) {
            int num = a[i];
            int size = al.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j : al)
                tmp.add(num + j);
            tmp.add(num);
            al.addAll(tmp);
        }
        pn(al.size());
        pn(al.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void soln1(int n, int[] a) {
        int maxx = n * 1000;
        boolean dp[][] = new boolean[n + 1][maxx + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxx; j++) {
                boolean prevValue = dp[i - 1][j];
                dp[i][j] = prevValue;
                boolean left = i - 1 >= 0 && j - a[i - 1] >= 0 && dp[i - 1][j - a[i - 1]];
                dp[i][j] = prevValue || left;
            }
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int j = 1; j <= maxx; j++)
            if (dp[n][j])
                al.add(j);
        pn(al.size());
        pn(al.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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
            new MoneySums().run();
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
