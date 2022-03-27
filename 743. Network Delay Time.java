import java.util.*;

class L743 {

    class Pair<T, Q> {
        T p1;
        Q p2;

        Pair(T a, Q b) {
            this.p1 = a;
            this.p2 = b;
        }

        T getKey() {
            return p1;
        };

        Q getValue() {
            return p2;
        };
    }

    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k, n);
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dijkstra(int[] signalReceivedAt, int source, int n) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(
                Comparator.comparing(Pair::getKey));
        pq.add(new Pair<Integer, Integer>(0, source));
        signalReceivedAt[source] = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();

            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();

            if (currNodeTime > signalReceivedAt[currNode] || !adj.containsKey(currNode)) {
                continue;
            }
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        L743 obj = new L743();
    }
}
