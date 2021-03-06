public class test {
    static boolean test(int a, int b) {
        if (a == b)
            return true;
        String bs = String.valueOf(b);
        if (bs.charAt(bs.length() - 1) == '1') {
            return test(a, bs.substring(0, bs.length() - 1).equals("") ? 0
                    : Integer.parseInt(bs.substring(0, bs.length() - 1)));
        } else {
            if (Integer.parseInt(bs) % 2 == 0) {
                return test(a, Integer.parseInt(bs) / 2);
            } else {
                return false;
            }
        }
    }

    static int fib(int n) {
        int a = 1, b = 2, c = 0;
        if (n == 1)
            return a;
        if (n == 2)
            return b;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(test(0, 81));
        System.out.println(test(1, 1111111111));
        System.out.println(test(1, 1231));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
    }
}
