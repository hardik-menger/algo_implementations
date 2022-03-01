import java.util.*;

class L2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0, right = (long) 1e14;
        while (left <= right) {
            long days = left + (right - left) / 2;
            long ans = 0;
            for (int i : time)
                ans += days / i;

            if (ans >= totalTrips)
                right = days - 1;
            else
                left = days + 1;
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        L2187 obj = new L2187();
    }
}
