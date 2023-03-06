import java.util.*;

import Utils.DSU;
import random.*;

class L695 {
    class Pair {
        int first;
        int second;

        Pair(int fst, int scnd) {
            this.first = fst;
            this.second = scnd;
        }
    }

    public int maxAreaOfIsland1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count = BFS(grid, i, j, 0);
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public int BFS(int[][] grid, int i, int j, int count) {
        grid[i][j] = 2;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));

        count++;
        int n = grid.length;
        int m = grid[0].length;

        int delRow[] = { -1, 1, 0, 0 };
        int delCol[] = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for (int k = 0; k < 4; k++) {
                int nrow = row + delRow[k];
                int ncol = col + delCol[k];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == 1) {
                    count++;
                    grid[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int dirs[][] = { { 1, 0 }, { 0, 1 } };
        DSU dsu = new DSU(grid[0].length * grid.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dsu.getSizes()[i * grid[0].length + j] = 1;
                    for (int[] dir : dirs) {
                        int i1 = i + dir[0], j1 = j + dir[1];
                        if (isSafe(grid, i1, j1) && grid[i1][j1] == 1) {
                            dsu.union(i * grid[0].length + j, i1 * grid[0].length + j1);
                        }
                    }
                } else
                    dsu.getSizes()[i * grid[0].length + j] = 0;
            }
        }
        int parents[] = dsu.getParents();
        int sizes[] = dsu.getSizes();
        int max = 0;
        for (int i = 0; i < parents.length; i++)
            max = Math.max(max, sizes[i]);
        return max;
    }

    boolean isSafe(int[][] grid, int i, int j) {
        return (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length);
    }

    public static void main(String[] args) throws Exception {
        L695 obj = new L695();
    }
}
