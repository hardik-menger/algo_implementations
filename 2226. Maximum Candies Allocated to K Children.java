import java.util.*;

class L2226 {

    public int maximumCandies(int[] candies, long k) {
        int ans = 0;
        int right = Arrays.stream(candies).max().getAsInt();
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(candies, mid, k)) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] candies, int mid, long k) {
        long possibleNo = 0;
        if (mid == 0)
            return true;
        for (int i : candies)
            possibleNo += i / mid;
        return possibleNo >= k;
    }

    public static void main(String[] args) throws Exception {
        L2226 obj = new L2226();
    }
}
