package Utils;

public class DSU {
    int parents[];
    int size[];

    public DSU(int n) {
        parents = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            if (size[a] < size[b]) {
                int temp = parentA;
                parentA = parentB;
                parentB = temp;
            }
            parents[parentB] = parentA;
            if (size[parentB] == 0)
                size[parentB]++;
            size[parentA] += size[parentB];
            return true;
        }
        return false;
    }

    public int find(int a) {
        if (parents[a] == a)
            return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }

    public int[] getSizes() {
        return size;
    }

    public int getSize(int index) {
        return size[index] == 0 ? 1 : size[index] + 1;
    }

    public int[] getParents() {
        return parents;
    }
}
