import java.util.*;

class L973 {

    public int[][] kClosest(int[][] points, int K) {
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int mid = partition(points, l, r);
            if (mid == K)
                break;
            else if (mid < K)
                l = mid + 1;
            else
                r = mid - 1;
        }
        int[][] res = new int[K][2];
        while (K - 1 >= 0) {
            res[K - 1] = points[K - 1];
            K--;
        }
        return res;
    }

    private int partition(int[][] points, int l, int r) {
        int pivot = points[r][0] * points[r][0] + points[r][1] * points[r][1];
        int newpivot = l;
        for (int i = l; i < r; i++) {
            if ((points[i][0] * points[i][0] + points[i][1] * points[i][1]) < pivot) {
                int[] temp = points[newpivot];
                points[newpivot] = points[i];
                points[i] = temp;
                newpivot++;
            }
        }
        int[] temp = points[newpivot];
        points[newpivot] = points[r];
        points[r] = temp;
        return newpivot;
    }

    public static void main(String[] args) throws Exception {
        L973 obj = new L973();
    }
}
