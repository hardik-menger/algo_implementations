import java.util.*;

class L874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }
        int x = 0, y = 0, direction = 0, maxDistSquare = 0;
        for (int i : commands) {
            if (i == -1) {
                direction = (direction + 1) % 4;
            } else if (i == -2) {
                direction = (direction + 3) % 4;
            } else {
                int step = 0;
                while (step < i
                        && (!obstaclesSet.contains(
                                (x + directions[direction][0]) + " " + (y + directions[direction][1])))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
        }
        return maxDistSquare;
    }

    public static void main(String[] args) throws Exception {
        L874 obj = new L874();
    }
}
