import java.util.*;

class L547 {

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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1)
                    dsu.union(i, j);
            }
        }
        return dsu.count;
    }

    public static void main(String[] args) throws Exception {
        L547 obj = new L547();
    }
}
