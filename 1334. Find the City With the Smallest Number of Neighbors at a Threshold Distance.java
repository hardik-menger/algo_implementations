import java.util.*;

class L1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int distanceTo[][] = new int[n][n];
        for (int distance[] : distanceTo)
            Arrays.fill(distance, 10001);
        for (int edge[] : edges)
            distanceTo[edge[0]][edge[1]] = distanceTo[edge[1]][edge[0]] = edge[2];
        for (int i = 0; i < n; i++)
            distanceTo[i][i] = 0;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    distanceTo[i][j] = Math.min(distanceTo[i][j], distanceTo[i][k] + distanceTo[k][j]);
        int smallestCount = n, ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distanceTo[i][j] <= distanceThreshold)
                    count++;
            }
            if (smallestCount >= count) {
                smallestCount = count;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L1334 obj = new L1334();
    }
}
