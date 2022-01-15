import java.util.*;
import java.io.*;

class Main392 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public boolean isSubsequence(String s, String t) {
        HashMap<Character, ArrayList<Integer>> pre = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!pre.containsKey(c))
                pre.put(c, new ArrayList<Integer>());
            pre.get(c).add(i);
        }
        int id = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ArrayList<Integer> list = pre.get(c);
            if (list == null)
                return false;
            int bi = Collections.binarySearch(list, id);
            if (bi < 0)
                bi = ~bi;
            System.out.println(list + "::::" + bi);
            if (bi == list.size())
                return false;
            if (bi < id)
                return false;
            id = bi + 1;
        }
        return true;
    }

    void solve(int TC) throws Exception {
        System.out.println(new Main392().isSubsequence("acb", "ahbgdc"));
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
            new Main392().run();
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
