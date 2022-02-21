import java.util.*;
import java.io.*;

class Main2171 {

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long n = beans.length;
        long sum = 0;
        for (int i = 0; i < beans.length; i++)
            sum += beans[i];
        long result = Long.MAX_VALUE;
        for (int i = 0; i < beans.length; i++, n--)
            result = Math.min(result, sum - n * beans[i]);
        return result;
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        System.out.println(minimumRemoval(new int[] { 4, 1, 6, 5 }));
        System.out.println(minimumRemoval(new int[] { 2, 10, 3, 2 }));
        System.out.println(minimumRemoval(new int[] { 94, 63, 43, 12 }));
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
            new Main2171().run();
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
