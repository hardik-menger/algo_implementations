import java.util.*;
import random.*;

class L352 {

    class SummaryRanges {
        TreeMap<Integer, Integer> tree;

        public SummaryRanges() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tree.containsKey(val))
                return;
            Integer l = tree.lowerKey(val);
            Integer h = tree.higherKey(val);
            if (l != null && h != null && tree.get(l) + 1 == val && h - 1 == val) {
                tree.put(l, tree.get(h));
                tree.remove(h);
            } else if (l != null && val <= tree.get(l) + 1) {
                tree.put(l, Math.max(tree.get(l), val));
            } else if (h != null && h - 1 == val) {
                tree.put(val, tree.get(h));
                tree.remove(h);
            } else {
                tree.put(val, val);
            }
        }

        public int[][] getIntervals() {
            int[][] intArray = new int[tree.size()][2];
            int index = 0;

            for (var num : tree.entrySet()) {
                intArray[index++] = new int[] { num.getKey(), num.getValue() };
            }

            return intArray;
        }
    }

    public static void main(String[] args) throws Exception {
        L352 obj = new L352();
    }
}
