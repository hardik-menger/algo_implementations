package random;

import java.util.*;
import java.io.*;
import static java.util.Map.entry;

class MainTaskScheduler {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve(int TC) throws Exception {

        // 'f': ['d'],
        // 'b': ['g', 'j'],
        // 'e': ['f'],
        // 'g': ['h'],
        // 'a': ['i'],
        // 'c': ['f'],
        // 'd': ['i'],
        // 'i': ['c', 'e']
        Map<Character, char[]> adj = Map.ofEntries(
                entry('f', new char[] { 'd' }),
                entry('b', new char[] { 'g', 'j' }),
                entry('e', new char[] { 'f' }),
                entry('g', new char[] { 'h' }),
                entry('a', new char[] { 'i' }),
                entry('c', new char[] { 'f' }),
                entry('d', new char[] { 'i' }),
                entry('i', new char[] { 'c', 'e' }));

        int V = 256;
        Stack<Character> stack = new Stack<Character>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one

        topologicalSortUtil('a', visited, stack, adj);
        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");

    }

    void topologicalSortUtil(char v, boolean visited[],
            Stack<Character> stack, Map<Character, char[]> adj) {
        visited[v] = true;
        if (adj.containsKey(v))
            for (char i : adj.get(v)) {
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack, adj);
            }
        stack.push(v);
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
            new MainTaskScheduler().run();
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
