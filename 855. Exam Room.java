import java.util.*;
import random.*;

class L855 {
    class ExamRoom {
        int capacity;
        TreeSet<Integer> set;

        public ExamRoom(int n) {
            capacity = n;
            set = new TreeSet<Integer>();
        }

        public int seat() {
            int ans = 0;
            if (set.size() > 0) {
                int distance = set.first();
                Integer prev = null;
                for (int curr : set) {
                    if (prev != null) {
                        int newdistance = (curr - prev) / 2;
                        if (newdistance > distance) {
                            distance = newdistance;
                            ans = prev + newdistance;
                        }
                    }
                    prev = curr;
                }
                if (distance < capacity - 1 - set.last()) {
                    ans = capacity - 1;
                }
            }
            set.add(ans);
            return ans;
        }

        public void leave(int p) {
            set.remove(p);
        }

    }

    public static void main(String[] args) throws Exception {
        L855 obj = new L855();
    }
}
