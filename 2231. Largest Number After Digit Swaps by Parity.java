import java.util.*;

class L2231 {

    public int largestInteger(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        char res[] = new char[len];
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        ArrayList<Integer> evenIdxs = new ArrayList<>();
        ArrayList<Integer> oddIdxs = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int d = str.charAt(i) - '0';
            if (d % 2 == 0) {
                evenIdxs.add(i);
                even.offer(d);
            } else {
                oddIdxs.add(i);
                odd.offer(d);
            }
        }

        int evenLastIdx = evenIdxs.size() - 1;
        int oddLastIdx = oddIdxs.size() - 1;
        while (even.size() > 0) {
            int val = even.poll();
            res[evenIdxs.get(evenLastIdx)] = (char) (val + '0');
            evenLastIdx--;
        }

        while (odd.size() > 0) {
            int val = odd.poll();
            res[oddIdxs.get(oddLastIdx)] = (char) (val + '0');
            oddLastIdx--;
        }

        return Integer.valueOf(new String(res));
    }

    public static void main(String[] args) throws Exception {
        L2231 obj = new L2231();
    }
}
