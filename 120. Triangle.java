import java.util.*;
import java.io.*;

class Main {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        HashMap<String, Integer> hm = new HashMap<>();
        return recursive(triangle, hm, 0, 0);
    }

    private int recursive(List<List<Integer>> triangle, HashMap<String, Integer> hm, int i, int j) {
        if (i > triangle.size() - 1 || j > triangle.get(i).size() - 1)
            return Integer.MAX_VALUE;
        if (i == triangle.size() - 1 && j < triangle.get(i).size())
            return triangle.get(i).get(j);
        String key = i + ":" + j;
        if (hm.containsKey(key))
            return hm.get(key);
        int res = triangle.get(i).get(j)
                + Math.min(recursive(triangle, hm, i + 1, j), recursive(triangle, hm, i + 1, j + 1));
        hm.put(key, res);
        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> al = new ArrayList<>();
            dp.add(al);
            for (int j = 0; j < triangle.get(i).size(); j++) {
                al.add(j, Math.min(
                        (dp.get(i - 1).size() > j) ? triangle.get(i).get(j) + dp.get(i - 1).get(j) : Integer.MAX_VALUE,
                        (dp.get(i - 1).size() > j - 1 && j - 1 >= 0) ? triangle.get(i).get(j)
                                + dp.get(i - 1)
                                        .get(j - 1)
                                : Integer.MAX_VALUE));
            }
        }
        return dp.get(triangle.size() - 1).stream().max((a, b) -> b - a).get();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();
        for (int i : triangle.get(0))
            dp.add(i);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> al = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                al.add(j, Math.min(
                        (dp.size() > j) ? triangle.get(i).get(j) + dp.get(j)
                                : Integer.MAX_VALUE,
                        (dp.size() > j - 1 && j - 1 >= 0) ? triangle.get(i).get(j) + dp.get(j - 1)
                                : Integer.MAX_VALUE));
            }
            dp = al;
        }
        return dp.stream().max((a, b) -> b - a).get();
    }

    void solve(int TC) throws Exception {
        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
        group.add(Arrays.asList(2));
        group.add(Arrays.asList(3, 4));
        group.add(Arrays.asList(6, 5, 7));
        group.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(group));
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
            new Main().run();
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
