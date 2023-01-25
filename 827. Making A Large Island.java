import java.util.*;

import Utils.DSU;

class L827 {
    public int largestIsland(int[][] grid) {
        DSU dsu = new DSU(grid.length * grid[0].length);
        int[][] crds = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < crds.length; k++) {
                        int ci = i + crds[k][0], cj = j + crds[k][1];
                        if (ci >= 0 && ci < grid.length && cj >= 0 && cj < grid[0].length) {
                            if (grid[ci][cj] == 1 && dsu.find(i * grid.length + j) != dsu.find(ci * grid.length + cj))
                                dsu.union(i * grid.length + j, ci * grid.length + cj);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<Integer>();
                    for (int k = 0; k < crds.length; k++) {
                        int ci = i + crds[k][0], cj = j + crds[k][1];
                        if (ci >= 0 && ci < grid.length && cj >= 0 && cj < grid[0].length) {
                            if (grid[ci][cj] == 1 && dsu.find(i * grid.length + j) != dsu.find(ci * grid.length + cj))
                                set.add(dsu.find(ci * grid.length + cj));
                        }
                    }
                    int localans = 0;
                    for (Integer a : set)
                        localans += dsu.getSizes()[a];
                    ans = Math.max(localans, ans + 1);
                }
            }
        }
        for (int i : dsu.getSizes())
            ans = Math.max(ans, i);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L827 obj = new L827();
    }
}
