import java.util.*;
import java.io.*;

class Main2170 {
    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> odd = new HashMap<Integer, Integer>();
        Map<Integer, Integer> even = new HashMap<Integer, Integer>();
        int evenNos = 0, oddNos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
                evenNos++;
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
                oddNos++;
            }
        }
        System.out.println(even);
        System.out.println(odd);

        int firstEvenCount = 0, firstEven = 0;
        int secondEvenCount = 0, secondEven = 0;

        for (Map.Entry<Integer, Integer> entry : even.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count >= firstEvenCount) {
                secondEvenCount = firstEvenCount;
                secondEven = firstEven;
                firstEvenCount = count;
                firstEven = num;
            }

            else if (count >= secondEvenCount) {
                secondEvenCount = count;
                secondEven = num;
            }
        }

        int firstOddCount = 0, firstOdd = 0;
        int secondOddCount = 0, secondOdd = 0;

        for (Map.Entry<Integer, Integer> entry : odd.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count >= firstOddCount) {
                secondOddCount = firstOddCount;
                secondOdd = firstOdd;
                firstOddCount = count;
                firstOdd = num;
            }

            else if (count >= secondOddCount) {
                secondOddCount = count;
                secondOdd = num;
            }
        }

        int operationsEven = 0, operationsOdd = 0;

        operationsEven = evenNos - firstEvenCount;

        if (firstEven != firstOdd)
            operationsEven += (oddNos - firstOddCount);
        else
            operationsEven += (oddNos - secondOddCount);

        operationsOdd = oddNos - firstOddCount;
        if (firstOdd != firstEven)
            operationsOdd += (evenNos - firstEvenCount);
        else
            operationsOdd += (evenNos - secondEvenCount);

        return Math.min(operationsEven, operationsOdd);
    }

    void solve(int TC) throws Exception {
        System.out.println(minimumOperations(new int[] { 3, 1, 3, 2, 4, 3 }));
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
            new Main2170().run();
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
