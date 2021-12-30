class BestSightseeingPair {
    // a+b-(j-i)====> a+i compared to b-j where j>i
    public int maxScoreSightseeingPair(int[] values) {
        int first = values[0] + 0, second = values[0] - 0;
        for (int i = 1; i < values.length; i++) {
            second = Math.max(second, first + values[i] - i);
            first = Math.max(first, values[i] + i);
        }
        return second;
    }
}
