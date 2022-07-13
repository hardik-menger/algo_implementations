import java.util.*;
import random.*;

class L1155 {

    int M = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        return run(n, k, target, map);
    }

    int run(int n, int k, int target, Map<String, Integer> map) {
        if (n == 0)
            return target != 0 ? 0 : 1;
        Integer res = map.get(n + ":" + k + ":" + target);
        if (res != null)
            return res;
        int to_return = 0;
        for (int i = 1; i <= k; i++) {
            to_return = (to_return + run(n - 1, k, target - i, map)) % M;
        }
        map.put(n + ":" + k + ":" + target, to_return);
        return to_return % M;
    }

    public static void main(String[] args) throws Exception {
        L1155 obj = new L1155();
        System.out.println(obj.numRollsToTarget(1, 6, 3));
        System.out.println(obj.numRollsToTarget(2, 6, 7));
        System.out.println(obj.numRollsToTarget(30, 30, 500));
    }
}
