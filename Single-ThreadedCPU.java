import java.util.*;

class LC1834 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; 
            } else {
                return a[2] - b[2]; 
            }
        });
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        var lastProcessed = (Arrays.stream(tasks).max((a, b) -> a[1] - b[1])).get();
        var timer = (Arrays.stream(tasks).min((a, b) -> a[0] - b[0])).get()[0];
        int i = 0;
        int res[] = new int[tasks.length];
        int ri = 0;
        System.out.println("input" + Arrays.deepToString(tasks));
        System.out.println("timer" + timer);
        while (!pq.isEmpty()||timer <= lastProcessed[1] || i < tasks.length) {
            while (i < tasks.length && timer >= tasks[i][0]) {
                pq.add(new int[] { tasks[i][0], tasks[i][1], tasks[i][2] });
                i++;
            }
            System.out.println("pg" + pq.size());
            if (pq.isEmpty())
                break;
            int[] task = pq.poll();
            res[ri++] = task[2];
            timer += task[1];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        LC1834 obj = new LC1834();
        int[][] array = {
                { 1, 2 },
                { 2, 4 },
                { 3, 2 },
                { 4, 1 }
        };
        int[][] array2 = {
                { 7, 10 },
                { 7, 12 },
                { 7, 5 },
                { 7, 4 },
                { 7, 2 }
        };

        int[][] array3 = {
                { 19, 13 },
                { 16, 9 },
                { 21, 10 },
                { 32, 25 },
                { 37, 4 },
                { 49, 24 },
                { 2, 15 },
                { 38, 41 },
                { 37, 34 },
                { 33, 6 },
                { 45, 4 },
                { 18, 18 },
                { 46, 39 },
                { 12, 24 }
        };
        System.out.println(Arrays.toString(obj.getOrder(array3)));

    }
}
