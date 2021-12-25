class ClimbingStairs {
    public int climbStairs(int n) {
        int pre = 1, curr = 1, temp = 0;
        while (curr < n) {
            temp = curr;
            curr += pre;
            pre = temp;
        }
        return curr;
    }

}
