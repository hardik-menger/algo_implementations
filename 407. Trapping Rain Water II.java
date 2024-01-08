import java.util.*;
import random.*;

class L407 {
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < heightMap.length; i++)
            for (int j = 0; j < heightMap[0].length; j++) {
                if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[0].length - 1) {
                    queue.offer(new int[] { i, j, heightMap[i][j] });
                    heightMap[i][j] = -1;
                }
            }
        int waterFilled = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int[] smallestHeightElement = queue.poll();
            int i = smallestHeightElement[0], j = smallestHeightElement[1];
            int currentHeight = smallestHeightElement[2];
            level = Math.max(level, currentHeight);

            for (int[] dir : dirs) {
                int ii = i + dir[0], jj = j + dir[1];
                if (ii >= 0 && ii < heightMap.length && jj >= 0 && jj < heightMap[0].length
                        && heightMap[ii][jj] != -1) {
                    int neighourHeight = heightMap[ii][jj];
                    queue.offer(new int[] { ii, jj, neighourHeight });
                    if (neighourHeight < level)
                        waterFilled += (level - neighourHeight);
                    heightMap[ii][jj] = -1;
                }
            }

        }
        return waterFilled;
    }

    public static void main(String[] args) throws Exception {
        L407 obj = new L407();
    }
}
