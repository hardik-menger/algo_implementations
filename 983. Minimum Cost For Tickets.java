import java.util.*;
import random.*;

class L983 {

    public int mincostTickets(int[] days, int[] costs) {
        int minDate = days[0];
        for (int i = 0; i < days.length; i++)
            days[i] = days[i] - minDate + 1;
        int dp[] = new int[days.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= dp.length; i++) {
            dp[i] = Math.min(calc(days, i, days[i] - 30) + costs[2],
                    Math.min(calc(days, i, days[i] - 1) + costs[0],
                            calc(days, i, days[i] - 7) + costs[1]));
        }
        return dp[dp.length - 1];
    }

    private int calc(int[] days, int index, int validTill) {
        while (index >= 0 && days[index] > validTill)
            index--;
        return index < 0 ? 0 : index;
    }

    public static void main(String[] args) throws Exception {
        L983 obj = new L983();
    }
}
