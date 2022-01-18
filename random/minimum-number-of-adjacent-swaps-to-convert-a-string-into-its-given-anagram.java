package random;

import java.util.*;
import java.io.*;

class Maingfg1 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    private int getNoOfSwaps(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int totalSwaps = 0;

        if (isOddPalindrome(s)) {
            char[] chars = s.toCharArray();
            int p1 = 0, p2 = chars.length - 1;

            while (p2 > p1) {
                if (chars[p1] != chars[p2]) {
                    int end = p2;
                    while (chars[end] != chars[p1])
                        end--;
                    if (end == p1) {
                        swap(chars, p1, p1 + 1);
                        totalSwaps++;
                    } else {
                        while (end < p2) {
                            swap(chars, end, end + 1);
                            totalSwaps++;
                            end++;
                        }
                        p1++;
                        p2--;
                    }
                } else {
                    p1++;
                    p2--; // When the characters are equal move on
                }
            }
            return totalSwaps;
        } else
            return -1;
    }

    private static void swap(char[] chars, int k, int i) {
        char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }

    private boolean isOddPalindrome(String s) {
        int[] occurrence = new int[26];
        int oddCount = 0;

        for (int i = 0; i < s.length(); i++)
            occurrence[s.charAt(i) - 'a']++;
        for (int value : occurrence)
            if (value % 2 != 0)
                oddCount++;
        return oddCount <= 1;
    }

    void solve(int TC) throws Exception {
        System.out.println(getNoOfSwaps("mamad"));
        System.out.println(getNoOfSwaps("asflkj"));
        System.out.println(getNoOfSwaps("aabb"));
        System.out.println(getNoOfSwaps("ntiin"));
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
            new Maingfg1().run();
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
