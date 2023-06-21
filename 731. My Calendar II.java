import java.util.*;
import random.*;

class L731 {

    public class Pair<T, Q> {
        public T p1;
        public Q p2;

        public Pair(T a, Q b) {
            this.p1 = a;
            this.p2 = b;
        }

        public Q getValue() {
            return this.p2;
        }

        public T getKey() {
            return this.p1;
        }
    }

    class MyCalendarTwo {
        private TreeMap<Integer, Integer> map;

        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
                if (count > 2) {
                    map.put(start, map.get(start) - 1);
                    if (map.get(start) == 0) {
                        map.remove(start);
                    }
                    map.put(end, map.get(end) + 1);
                    if (map.get(end) == 0) {
                        map.remove(end);
                    }
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Your MyCalendarTwo object will be instantiated and called as such:
     * MyCalendarTwo obj = new MyCalendarTwo();
     * boolean param_1 = obj.book(start,end);
     */

    public static void main(String[] args) throws Exception {
        L731 obj = new L731();
    }
}
