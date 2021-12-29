class BestSightseeingPair {
    // a+b-(j-i)====> a+i compared to b-j where j>i
    public int maxScoreSightseeingPair(int[] values) {
        int a = values[0] + 0, b = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            a = Math.max(a, b + values[i] - i);
            b = Math.max(b, values[i] + i);
        }
        return a;
    }
}
