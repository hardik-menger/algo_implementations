import java.util.*;

class L1483 {

    class TreeAncestor {

        int p[][];
        int pow;

        public TreeAncestor(int n, int[] parent) {
            pow = (int) (Math.log(n) / Math.log(2)) + 1;
            p = new int[n][pow];
            for (int i = 0; i < n; i++)
                p[i][0] = parent[i];
            for (int j = 1; j < pow; j++)
                for (int i = 0; i < n; i++) {
                    if (p[i][j - 1] == -1)
                        p[i][j] = -1;
                    else
                        p[i][j] = p[p[i][j - 1]][j - 1];
                }
        }

        public int getKthAncestor(int node, int k) {
            for (int j = 0; j < pow; j++) {
                if (((k >> j) & 1) == 1) {
                    node = p[node][j];
                    if (node == -1)
                        return -1;
                }
            }
            return node;
        }
    }

    public static void main(String[] args) throws Exception {
        L1483 obj = new L1483();
    }
}
