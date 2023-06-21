import java.util.*;
import random.*;

class L5436 {

    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        L5436 obj = new L5436();
    }
}
