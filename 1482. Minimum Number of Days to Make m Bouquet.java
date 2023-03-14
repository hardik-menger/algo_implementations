import java.util.*;
import random.*;

class L1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = Arrays.stream(bloomDay).max().getAsInt(), ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(bloomDay, m, k, mid)) {
                right = mid - 1;
                ans = mid;
            } else
                left = mid + 1;
        }
        return ans;
    }

    private boolean check(int[] bloomDays, int m, int k, int mid) {
        int adjacent = 0;
        for (int bloomDay : bloomDays) {
            adjacent = bloomDay <= mid ? adjacent + 1 : 0;
            if (adjacent == k) {
                adjacent = 0;
                --m;
            }
        }
        return m <= 0;
    }

    public static void main(String[] args) throws Exception {
        L1482 obj = new L1482();
    }
}
