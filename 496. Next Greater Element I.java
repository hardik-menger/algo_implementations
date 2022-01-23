import java.util.*;
import java.io.*;

class Main496 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i])
                map.put(nums2[stack.pop()], nums2[i]);
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public int[] prevGreaterElement(int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] > nums2[i]) {
                map.put(nums2[i], nums2[stack.pop()]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = map.getOrDefault(nums2[i], -1);
        }
        return nums2;
    }

    public int[] prevSmallerElement(int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] > nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[i], nums2[stack.peek()]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = map.getOrDefault(nums2[i], -1);
        }
        return nums2;
    }

    public int[] nextSmallerElement(int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] > nums2[i]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = map.getOrDefault(nums2[i], -1);
        }
        return nums2;
    }

    void solve(int TC) throws Exception {
        System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
        System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(nextGreaterElement(new int[] { 1, 3, 5, 2, 4 },
                new int[] { 6, 5, 4, 3, 2, 1, 7 })));
        System.out.println(Arrays.toString(prevGreaterElement(new int[] { 1, 3, 2, 4 })));
        System.out.println(Arrays.toString(prevGreaterElement(new int[] { 6, 5, 4, 3, 2, 1, 7 })));
        System.out.println(Arrays.toString(prevGreaterElement(new int[] { 1, 3, 4, 2 })));
        System.out.println(Arrays.toString(prevSmallerElement(new int[] { 4, 5, 2, 10, 8 })));
        System.out.println(Arrays.toString(nextSmallerElement(new int[] { 4, 5, 2, 10, 8 })));
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
            new Main496().run();
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
