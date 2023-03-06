import java.util.*;

class L825 {
    public int numFriendRequests(int[] ages) {
        int l = 0, r = ages.length - 1;
        Arrays.sort(ages);
        while (l <= r) {
            int x = ages[l], y = ages[r];
            while ((y > 100 && x < 100) || (y > x) || (y <= 0.5 * x + 7)) {

            }
        }
    }

    public static void main(String[] args) throws Exception {
        L825 obj = new L825();
    }
}
