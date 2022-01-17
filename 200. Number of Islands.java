import Utils.DSU;

class NumberofIslands {
    public int numIslands1(char[][] grid) {
        int no = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    no++;
                }
            }
        }
        return no;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public int numIslands(char[][] grid) {
        int dirs[][] = new int[][] { { 1, 0 }, { 0, 1 } };
        DSU dsu = new DSU(grid.length * grid[0].length);
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    for (int[] dir : dirs) {
                        int xd = i + dir[0], yd = j + dir[1];
                        int p = i * grid[0].length + j;
                        if (xd >= 0 && xd < grid.length && yd >= 0 && yd < grid[0].length && grid[xd][yd] == '1') {
                            if (dsu.union(p, xd * grid[0].length + yd))
                                count--;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofIslands().numIslands(new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
        }));

        System.out.println(new NumberofIslands().numIslands(new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' },
        }));

        System.out.println(new NumberofIslands().numIslands(new char[][] {
                { '1' }, { '1' }
        }));
        System.out.println(new NumberofIslands().numIslands(new char[][] {
                { '1', '1', '1' },
                { '0', '1', '0' },
                { '1', '1', '1' }
        }));

        System.out.println(new NumberofIslands().numIslands(new char[][] {
                { '1', '0', '1', '1', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '1', '1', '0', '1' }
        }));
    }
}
