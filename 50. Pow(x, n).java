import java.util.*;

class L50 {

    public double myPow(double x, int n) {
        double ans = 1;
        long nn = n;
        nn = Math.abs(nn);
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x;
                nn--;
            } else {
                x = x * x;
                nn /= 2;
            }
        }
        if (n < 0)
            ans = (double) 1.0 / (double) ans;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L50 obj = new L50();
    }
}
