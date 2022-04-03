import java.util.*;

class L2218 {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];
        return dp(piles, memo, 0, k);
    }

    public int dp(List<List<Integer>> piles, Integer[][] memo, int index, int k) {
        if (k == 0 || index == piles.size())
            return 0;
        if (memo[index][k] != null)
            return memo[index][k];
        int res = dp(piles, memo, index + 1, k), cur = 0;
        for (int i = 0; i < Math.min(k, piles.get(index).size()); i++) {
            cur += piles.get(index).get(i);
            res = Math.max(res, cur + dp(piles, memo, index + 1, k - i - 1));
        }
        return memo[index][k] = res;
    }

    // 2220. Minimum Bit Flips to Convert Number
    public int minBitFlips(int start, int goal) {
        String a = Integer.toBinaryString(start), b = Integer.toBinaryString(goal);
        int count = 0;
        int aI = a.length() - 1, bI = b.length() - 1;
        while (aI >= 0 && bI >= 0) {
            if (a.charAt(aI) != b.charAt(bI))
                count++;
            aI--;
            bI--;
        }
        while (bI >= 0) {
            if (b.charAt(bI) == '1')
                count++;
            bI--;
        }
        while (aI >= 0) {
            if (a.charAt(aI) == '1')
                count++;
            aI--;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L2218 obj = new L2218();
        System.out.println(obj.minBitFlips(10, 82));
        System.out.println(obj.minBitFlips(10, 7));
        System.out.println(obj.minBitFlips(3, 4));
    }
}
