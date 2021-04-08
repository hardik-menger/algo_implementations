import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class MergeIntervals {
    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Stack<Interval> st = new Stack<>();
        st.push(new Interval(intervals[0][0], intervals[0][1]));
        for (int j = 1; j < intervals.length; j++) {
            Interval firstChoice = st.peek();
            Interval incomingChoice = new Interval(intervals[j][0], intervals[j][1]);
            if (firstChoice.end < incomingChoice.start) {
                st.push(new Interval(incomingChoice.start, incomingChoice.end));
            } else if (firstChoice.end >= incomingChoice.start && incomingChoice.end > firstChoice.end) {
                st.pop();
                st.push(new Interval(firstChoice.start, incomingChoice.end));
            }
        }
        int res[][] = new int[st.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = st.get(i).start;
            res[i][1] = st.get(i).end;
        }
        return res;
    }
}
