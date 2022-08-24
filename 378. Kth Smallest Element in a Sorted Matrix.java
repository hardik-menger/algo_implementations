import java.util.*;
import random.*;

class L378 {

    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, matrix) >= k) {
                high = mid - 1;
                ans = mid;
            } else
                low = mid + 1;
        }
        return ans;
    }

    private int check(int mid, int[][] matrix) {
        int col = matrix[0].length - 1;
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            while (col >= 0 && matrix[row][col] > mid)
                col--;
            count += (col + 1);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L378 obj = new L378();
    }
}
