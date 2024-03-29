import java.util.*;

class L787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int adjMatrix[][] = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        Queue<int[]> minHeap = new LinkedList<>();
        minHeap.offer(new int[] { src, 0, 0 });
        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];
            if (stops == K + 1) {
                continue;
            }
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[] { nei, dU + wUV, stops + 1 });
                        distances[nei] = dU + wUV;
                    }
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

    public static void main(String[] args) throws Exception {
        L787 obj = new L787();
    }
}
