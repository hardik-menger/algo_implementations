import java.util.*;

class L1319 {
    class DSU {
        int parents[];
        int size[];
        int count;

        DSU(int n) {
            parents = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        int find(int a) {
            if (parents[a] == a)
                return a;
            return parents[a] = find(parents[a]);
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (size[b] > size[a]) {
                    int temp = size[b];
                    size[b] = size[a];
                    size[a] = temp;
                }
                parents[b] = a;
                size[b] += size[a];
                count--;
                return true;
            }
            return false;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int availableWires = 0;
        for (int i = 0; i < connections.length; i++) {
            if (dsu.union(connections[i][0], connections[i][1]) == false)
                availableWires++;
        }
        return (availableWires >= (dsu.count - 1)) ? dsu.count - 1 : -1;
    }

    public static void main(String[] args) throws Exception {
        L1319 obj = new L1319();
    }
}
