import java.util.*;

class L875 {

    public int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();
        Arrays.sort(piles);
        int low = 1, n = piles.length, best = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int hoursTaken = 0;
            for (int i : piles) {
                hoursTaken += Math.ceil(i / mid);
            }
            if (hoursTaken > h) {
                best = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return best;
    }

    public static void main(String[] args) throws Exception {
        L875 obj = new L875();
    }
}
