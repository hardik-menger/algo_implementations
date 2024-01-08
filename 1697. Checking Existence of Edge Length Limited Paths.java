import java.util.*;
import random.*;

class L1697 {
    class DSU {
        int parents[];
        int size[];

        DSU(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                if (size[pb] > size[pb]) {
                    int temp = pa;
                    pa = pb;
                    pb = temp;
                }
                parents[pb] = pa;
                size[pa] += size[pb];
                return true;
            } else
                return false;
        }

        public int find(int a) {
            if (parents[a] == a)
                return a;
            return parents[a] = find(parents[a]);
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int[][] sortedQueries = new int[queries.length][4]; // [u, v, limit, originalIndex].
        for (int i = 0; i < queries.length; ++i)
            sortedQueries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[2], b[2]));

        DSU dsu = new DSU(n);
        int i = 0;
        boolean[] result = new boolean[queries.length];
        for (var query : sortedQueries) {
            while (i < edgeList.length && edgeList[i][2] < query[2]) {
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            result[query[3]] = dsu.find(query[0]) == dsu.find(query[1]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        L1697 obj = new L1697();
    }
}
