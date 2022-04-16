import java.util.*;

class L2224 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for (int[] m : matches) {
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Integer player : losses.keySet()) {
            if (losses.get(player) == 0)
                r.get(0).add(player);
            if (losses.get(player) == 1)
                r.get(1).add(player);
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        L2224 obj = new L2224();
    }
}
