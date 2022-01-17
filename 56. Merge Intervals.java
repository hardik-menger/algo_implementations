import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> al = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (al.isEmpty() || al.get(al.size() - 1)[1] < interval[0]) {
                al.add(interval);
            } else {
                al.get(al.size() - 1)[1] = Math.max(al.get(al.size() - 1)[1], interval[1]);
            }
        }
        return al.toArray(new int[al.size()][]);
    }
}
