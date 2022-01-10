import java.util.*;

class MatrixPathSum {

    public int minPathSum1(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        solve1(grid, memo, 0, 0);
        return memo[0][0];
    }

    private int solve1(int[][] grid, int[][] memo, int i, int j) {
        if (i > grid.length - 1 || j > grid[0].length - 1)
            return Integer.MAX_VALUE;

        if (memo[i][j] != Integer.MAX_VALUE)
            return memo[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        else {
            int adder = Math.min(solve1(grid, memo, i + 1, j), solve1(grid, memo, i, j + 1));
            memo[i][j] = grid[i][j] + adder;
            return memo[i][j];
        }
    }

    public int minPathSum2(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        int dp[][] = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum3(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        int dp[][] = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            sum += grid[i][grid[0].length - 1];
            dp[i][grid[0].length - 1] = sum;
        }
        sum = 0;
        for (int i = grid[0].length - 1; i >= 0; i--) {
            sum += grid[grid.length - 1][i];
            dp[grid.length - 1][i] = sum;
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        int dp[][] = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String args[]) {
        MatrixPathSum mMatrixPathSum = new MatrixPathSum();
        int res[][] = { { 1, 2, 5 }, { 3, 2, 1 } };
        System.out.println(mMatrixPathSum.minPathSum(res));
    }
}
