class MatrixPathSum {
    public int minPathSum(int[][] grid) {
        return solve(grid, grid.length - 1, grid[0].length - 1);
    }

    private int solve(int[][] grid, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        System.out.println(i + "  " + j);
        int left = solve(grid, i - 1, j);
        int up = solve(grid, i, j - 1);
        return Math.min(left, up) + grid[i][j];
    }
}
