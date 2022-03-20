import java.util.*;

class L542 {

    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.add(new int[] { i, j });
                }
            }
        }
        int dirs[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int dir[] : dirs) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < mat.length && ny < mat[0].length) {
                    if (dist[nx][ny] > (dist[current[0]][current[1]] + 1)) {
                        dist[nx][ny] = dist[current[0]][current[1]] + 1;
                        queue.add(new int[] { nx, ny });
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        L542 obj = new L542();
    }
}
