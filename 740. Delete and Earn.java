class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int buckets[] = new int[10001];
        for (int i : nums)
            buckets[i] += i;
        int dp[] = new int[10001];
        int even = buckets[0], odd = buckets[1];
        for (int i = 2; i < dp.length; i++) {
            int temp = odd;
            odd = Math.max(buckets[i] + even, odd);
            even = temp;
        }
        return odd;
    }
}
