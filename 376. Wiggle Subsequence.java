import java.util.*;
import java.io.*;

class Main376 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int wiggleMaxLength1(int[] nums) {
        int[] down = new int[nums.length], up = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                } else if (nums[j] < nums[i]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] down = new int[nums.length], up = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i - 1] < nums[i]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int diff = nums[1] - nums[0];
        int ans = diff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int newdiff = nums[i] - nums[i - 1];
            if (newdiff < 0 && diff >= 0) {
                diff = newdiff;
                ans++;
            } else if (newdiff > 0 && diff <= 0) {
                diff = newdiff;
                ans++;
            }
        }
        return ans;
    }

    void solve(int TC) throws Exception {
        System.out.println(new Main376().wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
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
            new Main376().run();
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
