import java.util.*;
import random.*;

class L094 {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if (trips[0][0] > capacity)
            return false;
        for (int i = 0; i < trips.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= trips[i][1])
                capacity += queue.poll();
            capacity -= trips[i][0];
            queue.add(trips[i][0]);
            if (capacity < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        L094 obj = new L094();
        System.out.println(obj.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));
        System.out.println(obj.carPooling(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 3));
        System.out.println(obj.carPooling(new int[][] { { 9, 3, 4 }, { 9, 1, 7 }, { 4, 2, 4 }, { 7, 4, 5 } }, 23));
    }
}
