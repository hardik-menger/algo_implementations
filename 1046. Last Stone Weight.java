import java.util.*;
import random.*;

class L1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i : stones)
            q.add(i);
        int size = q.size();
        while (size >= 2) {
            int ele = q.poll();
            int ele2 = q.poll();
            q.add(ele - ele2);
            size--;
        }
        return q.poll();
    }

    public static void main(String[] args) throws Exception {
        L1046 obj = new L1046();
    }
}
