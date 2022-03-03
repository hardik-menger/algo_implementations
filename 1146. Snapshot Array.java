import java.util.*;
import java.util.Map.Entry;

class L1146 {

    static class SnapshotArray {
        TreeMap<Integer, Integer>[] A;
        int snap_id = 0;

        public SnapshotArray(int length) {
            A = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                A[i] = new TreeMap<Integer, Integer>();
                A[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            A[index].put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int snap_id) {
            return A[index].floorEntry(snap_id).getValue();
        }
    }

    public static void main(String[] args) throws Exception {
        L1146 ob = new L1146();
    }
}
