import java.util.*;
import random.*;

class L475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = -(int) (1e8);
        for (int val : houses) {
            int[] cf = ceilFloor(heaters, val);
            int ceil = cf[0], floor = cf[1];
            int d1 = Math.abs(ceil - val), d2 = Math.abs(floor - val);
            ans = Math.max(ans, Math.min(d1, d2));
        }
        return ans;
    }

    public int[] ceilFloor(int[] arr, int k) {
        int n = arr.length;
        int[] ans = { Integer.MAX_VALUE, Integer.MAX_VALUE };
        int si = 0, ei = n - 1;

        while (si <= ei) {
            int mid = (si + ei) >> 1;
            if (k == arr[mid]) {
                ans[0] = ans[1] = k;
                return ans;

            } else if (k < arr[mid]) {
                ans[0] = arr[mid];
                ei = mid - 1;
            } else {
                ans[1] = arr[mid];
                si = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L475 obj = new L475();
    }
}
