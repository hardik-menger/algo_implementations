import java.util.*;
import java.io.*;

class Main2140 {

    public long mostPoints1(int[][] questions) {
        HashMap<Integer, Long> questionsMap = new HashMap<Integer, Long>();
        return recursive(questions, 0, questionsMap);
    }

    private long recursive(int[][] questions, int i, HashMap<Integer, Long> questionsMap) {

        if (i >= questions.length)
            return 0;
        if (questionsMap.containsKey(i))
            return questionsMap.get(i);
        long res = Math.max(questions[i][0] + recursive(questions, 1 + i + questions[i][1],
                questionsMap),
                recursive(questions, i + 1, questionsMap));
        questionsMap.put(i, res);
        return res;
    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0], jump = questions[i][1];
            dp[i] = Math.max(points + dp[Math.min(jump + i + 1, n)], dp[i + 1]);
        }
        return dp[0];
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        System.out.println(mostPoints(new int[][] { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } }));
        System.out.println(mostPoints(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } }));
        System.out.println(mostPoints(new int[][] { { 12, 46 }, { 78, 19 }, { 63, 15 }, { 79, 62 }, { 13, 10 } }));
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
            new Main2140().run();
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
