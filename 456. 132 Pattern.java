import java.util.*;
import java.io.*;

class Main456 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public boolean find132pattern(int[] nums2) {
        return nextGreaterElement(nums2);
    }

    public boolean nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = stack.pop();
            }
            if (nums[i] < max)
                return true;
            if (nums[i] > max)
                stack.push(nums[i]);
        }
        return false;
    }

    void solve(int TC) throws Exception {
        System.out.println(find132pattern(new int[] { 1, 2, 3, 4 }));
        System.out.println(find132pattern(new int[] { 3, 1, 4, 2 }));
        System.out.println(find132pattern(new int[] { -1, 3, 2, 0 }));
        System.out.println(find132pattern(new int[] { 1, 0, 1, -4, -3 }));
        System.out.println(find132pattern(new int[] { 3, 5, 0, 3, 4 }));
        System.out.println(find132pattern(new int[] { 1, 0, 1, -4, -3 }));
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
            new Main456().run();
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
