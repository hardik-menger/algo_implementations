import java.util.*;
import random.*;

class L64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for (int row = height - 1; row >= 0; row--) {
            for (int col = width - 1; col >= 0; col--) {
                if (row == height - 1 && col == width - 1)
                    grid[row][col] = grid[row][col];
                else if (row == 0 && col != 0)
                    grid[row][col] += grid[row][col - 1];
                else if (col == 0 && row != 0)
                    grid[row][col] += grid[row - 1][col];
                else
                    grid[row][col] += Math.min(grid[row + 1][col], grid[row][col + 1]);
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) throws Exception {
        L64 obj = new L64();
    }
}
