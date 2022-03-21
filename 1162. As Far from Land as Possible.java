import java.util.*;

class L1162 {

    public int maxDistance(int[][] mat) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == 1)
                    queue.add(new int[] { i, j });
            }
        }
        int steps = 1;
        int dirs[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int newi = current[0] + dir[0];
                    int newj = current[1] + dir[1];
                    if (newi >= 0 && newj >= 0 && newi < mat.length && newj < mat.length && mat[newi][newj] == 0) {
                        mat[newi][newj] = steps + 1;
                        queue.add(new int[] { newi, newj });
                    }
                }
            }
            steps++;
        }
        for (int[] a : mat)
            System.out.println(Arrays.toString(a));
        return steps;

    }

    public static void main(String[] args) throws Exception {
        L1162 obj = new L1162();
    }
}
