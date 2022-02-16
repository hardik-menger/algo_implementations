import java.util.*;
import java.io.*;

class Main1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;

        int[] snums1 = nums1.clone();
        Arrays.sort(snums1);

        int maxDiff = 0;
        int pos = 0;
        int newn1 = 0;

        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            int origDiff = Math.abs(nums1[i] - n2);
            int floor = arrayFloor(snums1, n2);
            if (floor > Integer.MIN_VALUE) {
                int newDiff = Math.abs(floor - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = floor;
                    maxDiff = diff;
                }
            }
            int ceiling = arrayCeiling(snums1, n2);
            if (ceiling < Integer.MAX_VALUE) {
                int newDiff = Math.abs(ceiling - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = ceiling;
                    maxDiff = diff;
                }
            }
        }
        if (newn1 > 0) {
            nums1[pos] = newn1;
        }
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
        }
        return sum;
    }

    private int arrayFloor(int[] arr, int val) {
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                low = mid + 1;
                ans = arr[mid];
            } else if (arr[mid] > val) {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int arrayCeiling(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= val) {
                min = arr[mid];
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return min;
    }

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {
        int n = ni();
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
            new Main1818().run();
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
