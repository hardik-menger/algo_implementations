import java.util.*;
import java.io.*;

class Main2150 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0).intValue() == 1 && map.getOrDefault(nums[i] - 1, 0).intValue() == 0
                    && map.getOrDefault(nums[i] + 1, 0).intValue() == 0)
                result.add(nums[i]);
        }
        return result;
    }

    void solve(int TC) throws Exception {
        System.out.println(findLonely(new int[] { 10, 6, 5, 8 }));
        System.out.println(findLonely(new int[] { 1, 3, 5, 3 }));
        System.out.println(findLonely(new int[] { 62, 35, 59, 55, 84, 61, 38, 87, 55, 82 }));
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
            new Main2150().run();
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
