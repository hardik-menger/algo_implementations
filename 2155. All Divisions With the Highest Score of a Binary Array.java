import java.util.*;
import java.io.*;

class Main2155 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public List<Integer> maxScoreIndices(int[] nums) {
        int left[] = new int[nums.length], right[] = new int[nums.length];
        if (nums[nums.length - 1] == 1)
            right[nums.length - 1] = 1;
        if (nums[0] == 0)
            left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1];
            if (nums[i] == 0)
                left[i]++;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (nums[i] == 1)
                right[i]++;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < right.length; i++) {
            int local = (i == 0 ? 0 : left[i - 1]) + right[i];
            if (local > max) {
                max = local;
                al.clear();
            }
            if (local == max) {
                al.add(i);
            }
        }
        if (left[nums.length - 1] > max) {
            al.clear();
            al.add(nums.length);
        }
        if (left[nums.length - 1] == max) {
            al.add(nums.length);
        }
        return al;
    }

    void solve(int TC) throws Exception {
        System.out.println(maxScoreIndices(new int[] { 0, 0, 1, 0 }));
        System.out.println(maxScoreIndices(new int[] { 0, 0, 0 }));
        System.out.println(maxScoreIndices(new int[] { 1, 1 }));
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
            new Main2155().run();
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
