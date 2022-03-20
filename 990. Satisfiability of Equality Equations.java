import java.util.*;

class L990 {
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

    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for (String e : equations)
            if (e.charAt(1) == '=')
                dsu.union(e.charAt(0) - 'a', e.charAt(3) - 'a');
        for (String e : equations)
            if (e.charAt(1) != '=' && dsu.find(e.charAt(0) - 'a') == dsu.find(e.charAt(3) - 'a'))
                return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        L990 obj = new L990();
    }
}
