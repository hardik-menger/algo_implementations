class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] indexer = new int[rows][cols];
        boolean[][] seenPacificOcean = new boolean[rows][cols];
        boolean[][] seenAtlanticOcean = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            helper(heights, i, 0, seenPacificOcean);
            helper(heights, i, cols - 1, seenAtlanticOcean);
        }
        for (int i = 0; i < cols; i++) {
            helper(heights, 0, i, seenPacificOcean);
            helper(heights, rows - 1, i, seenAtlanticOcean);
        }
        List<List<Integer>> grids = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seenPacificOcean[i][j] && seenAtlanticOcean[i][j]) {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    grids.add(coordinates);
                }
            }
        }
        return grids;
    }

    void helper(int[][] matrix, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        if (row > 0 && !visited[row - 1][col] && matrix[row][col] <= matrix[row - 1][col]) {
            helper(matrix, row - 1, col, visited);
        }
        if (row != matrix.length - 1 && !visited[row + 1][col] && matrix[row][col] <= matrix[row + 1][col]) {
            helper(matrix, row + 1, col, visited);
        }
        if (col > 0 && !visited[row][col - 1] && matrix[row][col] <= matrix[row][col - 1]) {
            helper(matrix, row, col - 1, visited);
        }
        if (col != matrix[0].length - 1 && !visited[row][col + 1] && matrix[row][col] <= matrix[row][col + 1]) {
            helper(matrix, row, col + 1, visited);
        }

    }

}
