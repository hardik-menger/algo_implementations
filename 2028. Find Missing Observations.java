import java.util.*;

class L2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum(), m = rolls.length;
        int missingsum = mean * (n + m) - sum;
        if (missingsum < n || missingsum > 6 * n)
            return new int[0];
        int ans[] = new int[n];
        int initial = missingsum / n, rem = missingsum % n;
        Arrays.fill(ans, initial);
        for (int i = 0; i < rem; i++)
            ans[i]++;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L2028 obj = new L2028();
    }
}
