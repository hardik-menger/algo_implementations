import java.util.*;

class RottingOranges {
    class Pair<T, Q> {
        T p1;
        Q p2;

        Pair(T a, Q b) {
            this.p1 = a;
            this.p2 = b;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        HashSet<String> hs = new HashSet<>();
        int countfresh = 0;
        if (grid.length == 1) {
            int ones = 0, zeros = 0;
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[0][i] == 0)
                    zeros++;
                if (grid[0][i] == 1)
                    ones++;
            }
            if (ones == grid[0].length)
                return 0;
            if (zeros == grid[0].length)
                return -1;
        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<Integer, Integer>(i, j));
                    hs.add(i + ":" + j);
                }
                if (grid[i][j] == 1)
                    countfresh++;
            }
        int ans = 0;
        while (true) {
            int len = queue.size();
            if (len == 0)
                break;
            while (len-- != 0) {
                Pair<Integer, Integer> ele = queue.poll();
                hs.add(ele.p1 + ":" + ele.p2);
                int p = ele.p1, q = ele.p2;
                int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                for (int i = 0; i < 4; i++) {
                    int ii = p + dirs[i][0];
                    int jj = q + dirs[i][1];
                    if (isSafe(ii, jj, grid) && grid[ii][jj] == 1 && !hs.contains((ii) + ":" + (jj))) {
                        grid[ii][jj] = 2;
                        queue.add(new Pair<Integer, Integer>(ii, jj));
                        countfresh--;
                    }
                }
            }
            ans++;
        }

        return countfresh != 0 ? -1 : ans - 1;
    }

    private boolean isSafe(int i, int j, int[][] grid) {
        return (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length);
    }
}
