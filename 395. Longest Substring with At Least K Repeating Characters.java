import java.util.*;
import java.io.*;

class Main395 {

    public int longestSubstring(String s, int k) {
        int unique = findUnique(s), globalAns = 0;
        for (int localAns = 1; localAns <= unique; localAns++) {
            int uniqueMap[] = new int[26];
            int i = 0, j = 0, totalUnique = 0, totalCountAleastKChars = 0;
            while (j < s.length()) {
                if (totalUnique <= localAns) {
                    if (uniqueMap[s.charAt(j) - 'a'] == 0) {
                        totalUnique++;
                    }
                    uniqueMap[s.charAt(j) - 'a']++;
                    if (uniqueMap[s.charAt(j) - 'a'] == k)
                        totalCountAleastKChars++;
                    j++;

                } else {
                    if (uniqueMap[s.charAt(i) - 'a'] == k)
                        totalCountAleastKChars--;
                    uniqueMap[s.charAt(i) - 'a']--;
                    if (uniqueMap[s.charAt(i) - 'a'] == 0)
                        totalUnique--;
                    i++;
                }
                if (totalUnique == localAns && totalUnique == totalCountAleastKChars)
                    globalAns = Math.max(j - i, globalAns);
            }
        }
        return globalAns;
    }

    private int findUnique(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
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
            new Main395().run();
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
