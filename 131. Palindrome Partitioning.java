import java.util.*;
import java.io.*;

class Main131 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public List<List<String>> partition(String s) {
        List<List<String>> all = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(all, path, s, 0);
        return all;
    }

    private void backtrack(List<List<String>> all, List<String> path, String s, int from) {
        if (from >= s.length()) {
            all.add(new ArrayList<>(path));
            return;
        } else
            for (int to = from + 1; to <= s.length(); to++) {
                if (isPalindrome(s, from, to - 1)) {
                    String substr = s.substring(from, to);
                    path.add(substr);
                    backtrack(all, path, s, to);
                    path.remove(path.size() - 1);
                }
            }
    }

    private boolean isPalindrome(String path, int i, int j) {
        while (i <= j)
            if (!(path.charAt(i++) == path.charAt(j--)))
                return false;
        return true;
    }

    void solve(int TC) throws Exception {
        System.out.println(partition("aab"));
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
            new Main131().run();
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
