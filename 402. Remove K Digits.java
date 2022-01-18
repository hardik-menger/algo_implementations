import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Main402 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public String removeKdigits(String num, int k) {
        if (k == 0)
            return num;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && num.charAt(i) < st.peek()) {
                st.pop();
                k--;
            }
            if (!st.isEmpty() || num.charAt(i) != '0')
                st.push(num.charAt(i));
        }
        while (!st.isEmpty() && k-- != 0)
            st.pop();
        if (st.isEmpty())
            return "0";
        ArrayList<Character> ch = new ArrayList<Character>();
        while (!st.isEmpty()) {
            ch.add(st.pop());
        }
        Collections.reverse(ch);
        return ch.stream().map(Object::toString)
                .collect(Collectors.joining(""));
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
            new Main402().run();
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
