import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int bottom = matrix.length, right = matrix[0].length;
        int left = 0, top = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while (left < right && top < bottom) {
            for (int col = left; col < right; col++) {
                al.add(matrix[top][col]);
            }
            top++;
            for (int row = top; row < bottom; row++) {
                al.add(matrix[row][right - 1]);
            }
            right--;

            if (bottom > top) {
                for (int col = right - 1; col >= left; col--) {
                    al.add(matrix[bottom - 1][col]);
                }
                bottom--;
            }

            if (right > left) {
                for (int row = bottom - 1; row >= top; row--) {
                    al.add(matrix[row][left]);
                }
                left++;
            }
        }
        return al;
    }
}
