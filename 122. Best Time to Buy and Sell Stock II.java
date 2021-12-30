class Solution {
    public int maxProfit(int[] a) {
        int i = 0, peak = a[0], dip = a[0], ans = 0;
        for (i = 0; i < a.length; i++) {
            while (i <= a.length - 2 && a[i + 1] < a[i])
                i++;
            if (i == a.length - 1)
                return ans;
            dip = a[i];
            while (i <= a.length - 2 && a[i + 1] > a[i])
                i++;
            peak = a[i];
            ans += peak - dip;
        }
        return ans;
    }
}