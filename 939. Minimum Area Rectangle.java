import java.util.*;
import random.*;

class L939 {

    public int minAreaRect(int[][] points) {
        HashMap<Integer, Set<Integer>> hashmap = new HashMap<>();

        for (int single_point[] : points) {
            if (!hashmap.containsKey(single_point[0]))
                hashmap.put(single_point[0], new HashSet<Integer>());
            hashmap.get(single_point[0]).add(single_point[1]);
        }

        int minimum_area = Integer.MAX_VALUE;
        // find diagonal x1,y1 and x2,y2 the other should points should be x1,y2 and
        // x2,y1
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {

                int x1 = points[i][0], y1 = points[i][1];

                int x2 = points[j][0], y2 = points[j][1];

                if (x1 != x2 && y1 != y2)
                    if (hashmap.get(x1).contains(y2) && hashmap.get(x2).contains(y1))
                        minimum_area = Math.min(minimum_area, Math.abs(x1 - x2) * Math.abs(y1 - y2));
            }
        }
        return minimum_area != Integer.MAX_VALUE ? minimum_area : 0;
    }

    public static void main(String[] args) throws Exception {
        L939 obj = new L939();
    }
}
