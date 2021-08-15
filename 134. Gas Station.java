class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int rem = 0, start = 0;
        for (int i = 0; i < cost.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            rem += (gas[i] - cost[i]);
            if (rem < 0) {
                start = i + 1;
                rem = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        } else {
            return start;
        }
    }
}
