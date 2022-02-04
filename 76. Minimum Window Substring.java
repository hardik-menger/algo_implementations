import java.util.*;
import java.io.*;

class Main76 {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>(),
                runningMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++)
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) + 1);
        int goal = counts.size();
        int progress = 0;
        int i = 0, j = 0;
        int[] ans = { -1, 0, 0 };
        while (j < s.length()) {
            char ch = s.charAt(j);
            runningMap.put(ch, runningMap.getOrDefault(ch, 0) + 1);
            if (counts.containsKey(ch) && runningMap.containsKey(ch) && runningMap.get(ch)
                    .intValue() == counts.get(ch).intValue()) {
                progress++;
            }

            while (i <= j && progress == goal) {
                if (ans[0] == -1 || j - i + 1 < ans[0]) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }
                ch = s.charAt(i);
                runningMap.put(ch, runningMap.get(ch) - 1);
                if (counts.containsKey(ch) && runningMap.containsKey(ch)
                        && runningMap.get(ch).intValue() < counts.get(ch).intValue())
                    progress--;
                i++;
            }
            j++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
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
            new Main76().run();
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
