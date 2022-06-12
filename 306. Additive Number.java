import java.util.*;

class L306 {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long a = parse(num.substring(0, i));
                long b = parse(num.substring(i, j));
                if (a == -1 || b == -1)
                    continue;
                boolean ans = dfs(a, b, num.substring(j));
                if (ans)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(long a, long b, String substring) {
        long sum = a + b;
        String sumString = String.valueOf(sum);
        if (substring.length() == 0)
            return true;
        if (substring.startsWith(sumString) && substring.length() >= sumString.length()) {
            return dfs(b, sum, substring.substring(sumString.length()));
        }
        return false;
    }

    private long parse(String substring) {
        if (!substring.equals("0") && substring.charAt(0) == '0')
            return -1;
        return Long.parseLong(substring);
    }

    public static void main(String[] args) throws Exception {
        L306 obj = new L306();
        System.out.println(obj.isAdditiveNumber("112358"));
        System.out.println(obj.isAdditiveNumber("199100199"));
        System.out.println(obj.isAdditiveNumber("19910019"));
        System.out.println(obj.isAdditiveNumber("101"));
    }
}
