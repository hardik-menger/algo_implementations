import java.util.HashSet;

class L2154 {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : nums)
            hs.add(i);
        while (hs.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
