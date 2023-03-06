import java.util.*;
import random.*;

class L934 {
    int dirs[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int shortestBridge(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean found1 = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int ele = grid[i][j];
                if (ele == 1) {
                    markAsVisitedAndGrabCandidates(grid, queue, i, j);
                    found1 = true;
                    break;
                }
            }
            if (found1)
                break;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                Pair<Integer, Integer> ele = queue.poll();
                grid[ele.p1][ele.p2] = 2;

                for (int dir[] : dirs) {
                    int i1 = dir[0] + ele.p1;
                    int j1 = dir[1] + ele.p2;
                    if (isSafe(grid, i1, j1) && grid[i1][j1] == 0) {
                        grid[i1][j1] = 2;
                        queue.add(new Pair<Integer, Integer>(i1, j1));
                    }
                    if (isSafe(grid, i1, j1) && grid[i1][j1] == 1)
                        return res;
                }
            }
            res++;
        }
        return res;
    }

    private void markAsVisitedAndGrabCandidates(int[][] grid, Queue<Pair<Integer, Integer>> queue, int i, int j) {
        if (!isSafe(grid, i, j) || grid[i][j] != 1)
            return;
        grid[i][j] = 2;
        boolean iscandidate = false;
        for (int dir[] : dirs) {
            int i1 = dir[0] + i;
            int j1 = dir[1] + j;
            if (isSafe(grid, i1, j1) && grid[i1][j1] == 0) {
                iscandidate = true;
            }
            if (isSafe(grid, i1, j1) && grid[i1][j1] == 1)
                markAsVisitedAndGrabCandidates(grid, queue, i1, j1);
        }
        if (iscandidate) {
            queue.add(new Pair<Integer, Integer>(i, j));
            System.out.println(i + " :: " + j);
        }
    }

    boolean isSafe(int[][] grid, int i, int j) {
        return (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length);
    }

    public static void main(String[] args) throws Exception {
        L934 obj = new L934();
    }
}
