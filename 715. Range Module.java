import java.util.*;
import random.*;

class L715 {
    class RangeModule {
        TreeMap<Integer, Integer> mp;

        public RangeModule() {
            mp = new TreeMap();
        }

        public void addRange(int left, int right) {
            var lo = mp.floorEntry(left);
            var ro = mp.floorEntry(right);
            if (lo != null && lo.getValue() >= left)
                left = lo.getKey();
            if (ro != null && ro.getValue() > right)
                right = ro.getValue();
            mp.subMap(left, right + 1).clear();
            mp.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            var e = mp.floorEntry(left);
            if (e != null && e.getValue() >= right)
                return true;
            return false;
        }

        public void removeRange(int left, int right) {
            var lo = mp.floorEntry(left);
            var ro = mp.floorEntry(right);
            mp.subMap(left, right + 1).clear();
            if (lo != null && lo.getValue() > left)
                mp.put(lo.getKey(), left);
            if (ro != null && ro.getValue() > right)
                mp.put(right, ro.getValue());
        }

    }

    public static void main(String[] args) throws Exception {
        L715 obj = new L715();
    }
}
