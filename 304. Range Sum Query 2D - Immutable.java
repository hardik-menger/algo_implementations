class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        sum = new int[m + 1][n + 1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        r1++;
        c1++;
        r2++;
        c2++;
        return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        NumMatrix obj = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
        System.out.println(obj.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(obj.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(obj.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
    }
}
