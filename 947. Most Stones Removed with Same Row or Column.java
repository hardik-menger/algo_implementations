import java.util.*;

class L947 {

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

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(1000);
        dsu.count = stones.length;
        for (int i = 0; i < n; i++) {
            int stone1[] = stones[i];
            for (int j = i + 1; j < n; j++) {
                int stone2[] = stones[j];
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    dsu.union(i, j);
                }
            }
        }
        return stones.length - dsu.count;
    }

    public static void main(String[] args) throws Exception {
        L947 obj = new L947();
    }
}
