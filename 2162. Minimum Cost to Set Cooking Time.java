import java.util.*;
import java.io.*;

class Main2162 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        if (startAt == moveCost && moveCost == pushCost && pushCost == targetSeconds)
            return 1;
        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;
        if (minutes > 99) {
            seconds += ((minutes - 99) * 60);
            minutes = 99;
        }
        int cost = findCost(startAt, moveCost, pushCost, minutes, seconds);
        while (minutes-- != 0) {
            seconds += 60;
            if (seconds > 99)
                break;
            cost = Math.min(cost, findCost(startAt, moveCost, pushCost, minutes, seconds));
        }
        return cost;
    }

    private int findCost(int startAt, int moveCost, int pushCost, int minutes, int seconds) {
        List<Integer> digits = getDigits(minutes);

        int cost = 0;
        if (minutes == 0)
            digits.clear();
        for (int digit : digits) {
            if (digit != startAt) {
                cost += moveCost;
            }
            startAt = digit;
            cost += pushCost;
        }

        digits = getDigits(seconds);
        if (digits.size() == 1 && minutes != 0)
            digits.add(0, 0);
        for (int digit : digits) {
            if (digit != startAt) {
                cost += moveCost;
            }
            startAt = digit;
            cost += pushCost;
        }
        return cost;
    }

    private List<Integer> getDigits(int number) {
        ArrayList<Integer> digits = new ArrayList<>();
        if (number == 0)
            digits.add(0);
        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    void solve(int TC) throws Exception {
        System.out.println(minCostSetTime(1, 2, 1, 600));
        System.out.println(minCostSetTime(0, 1, 2, 76));
        System.out.println(minCostSetTime(1, 1, 1, 1));
        System.out.println(minCostSetTime(5, 15, 20, 365));
        System.out.println(minCostSetTime(0, 1, 4, 9));
        System.out.println(minCostSetTime(1, 1, 1, 6000));
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
            new Main2162().run();
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
