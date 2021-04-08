import java.util.*;

class MatrixPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        solve(grid, memo, 0, 0);
        return memo[0][0];
    }

    private int solve(int[][] grid, int[][] memo, int i, int j) {
        if (i > grid.length - 1 || j > grid[0].length - 1)
            return Integer.MAX_VALUE;

        if (memo[i][j] != Integer.MAX_VALUE)
            return memo[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        else {
            int adder = Math.min(solve(grid, memo, i + 1, j), solve(grid, memo, i, j + 1));
            memo[i][j] = grid[i][j] + adder;
            return memo[i][j];
        }
    }

    public static void main(String args[]) {
        MatrixPathSum mMatrixPathSum = new MatrixPathSum();
        int res[][] = { { 1, 2, 5 }, { 3, 2, 1 } };
        System.out.println(mMatrixPathSum.minPathSum(res));
    }
}
