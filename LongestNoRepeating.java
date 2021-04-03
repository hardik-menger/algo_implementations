class LongestNoRepeating {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, l = 0, r = 0, count[] = new int[256];
        while (r < s.length()) {
            char c = s.charAt(r);
            while (count[c] > 0) {
                --count[s.charAt(l)];
                ++l;
            }
            ++count[c];
            ++r;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}