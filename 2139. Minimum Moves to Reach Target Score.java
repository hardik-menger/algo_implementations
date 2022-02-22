import java.util.*;
import java.io.*;

class Main2139 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        System.out.println(minMoves(19, 2));
        System.out.println(minMoves(10, 4));
        System.out.println(minMoves(5, 0));
        System.out.println(minMoves(766972377, 92));
    }

    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target > 1 && (maxDoubles-- != 0)) {
            res += 1 + target % 2;
            target /= 2;
        }
        return res + target - 1;
    }

    public int minMoves1(int target, int maxDoubles) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return recursive(target, maxDoubles, map) - 1;
    }

    private int recursive(int target, int maxDoubles, HashMap<String, Integer> map) {
        if (target < 0)
            return Integer.MAX_VALUE;
        if (target == 0)
            return 0;
        if (map.containsKey(target + ":" + maxDoubles))
            return map.get(target + ":" + maxDoubles);
        int res = -1;
        if (maxDoubles > 0 && target % 2 == 0)
            res = 1 + Math.min(recursive(target - 1, maxDoubles, map), recursive(target / 2, maxDoubles - 1, map));
        else
            res = 1 + recursive(target - 1, maxDoubles, map);
        map.put(target + ":" + maxDoubles, res);
        return res;
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
            new Main2139().run();
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
