import java.util.*;
import java.util.Map.Entry;

import random.*;

class L2276 {

    static class CountIntervals {
        TreeMap<Integer, Integer> map;
        int count;

        public CountIntervals() {
            map = new TreeMap<>();
            count = 0;
        }

        public void add(int left, int right) {
            var lowEntry = map.floorEntry(left);
            if (lowEntry == null || lowEntry.getValue() < left)
                lowEntry = map.higherEntry(left);
            for (var overlappingEntry = lowEntry; overlappingEntry != null
                    && overlappingEntry.getKey() <= right; overlappingEntry = map.higherEntry(left)) {
                left = Math.min(left, overlappingEntry.getKey());
                right = Math.max(right, overlappingEntry.getValue());
                count -= (overlappingEntry.getValue() - overlappingEntry.getKey() + 1);
                map.remove(overlappingEntry.getKey());
            }
            map.put(left, right);
            count += (right - left + 1);
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        L2276.CountIntervals obj = new L2276.CountIntervals();
        obj.add(2, 5);
        obj.add(6, 8);
        System.out.println(obj.map);
    }
}
