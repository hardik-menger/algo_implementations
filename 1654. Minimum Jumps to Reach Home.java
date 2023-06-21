import java.util.*;
import random.*;

class L1654 {
    HashSet<Integer> visited = new HashSet<>();

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : forbidden)
            set.add(i);

        int ans = recursive(0, a, b, x, true, set);
        if (ans >= (int) 1e9)
            return -1;
        return ans;
    }

    private int recursive(int i, int a, int b, int x, boolean isBackward, Set<Integer> set) {
        if (visited.contains(i) || i < 0 || i > 6000 || set.contains(i))
            return (int) 1e9;
        if (i == x)
            return 0;
        if (isBackward)
            visited.add(i);
        if (isBackward)
            return 1 + Math.min(recursive(i + a, a, b, x, true, set), recursive(i - b, a, b, x, false, set));
        return recursive(i + a, a, b, x, true, set);
    }

    public static void main(String[] args) throws Exception {
        L1654 obj = new L1654();
    }
}
