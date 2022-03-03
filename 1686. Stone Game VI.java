import java.util.*;

class L1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int sum[][] = new int[aliceValues.length][];
        for (int i = 0; i < aliceValues.length; i++) {
            sum[i] = new int[] { aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i] };
        }
        Arrays.sort(sum, (a, b) -> b[0] - a[0]);
        int aliceSum = 0, bobSum = 0;
        for (int i = 0; i < sum.length; i++) {
            if (i % 2 == 0)
                aliceSum += sum[i][1];
            else
                bobSum += sum[i][2];
        }
        return Integer.compare(aliceSum, bobSum);
    }

    public static void main(String[] args) throws Exception {
        L1686 obj = new L1686();
    }
}
