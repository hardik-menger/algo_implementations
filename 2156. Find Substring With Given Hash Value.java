class L2156 {
    public String subStrHash(String t, int power, int mod, int k, int hashValue) {
        char[] s = t.toCharArray();
        int n = s.length;
        long h = 0;
        int first = n;
        long pk = 1;
        for (int i = 0; i < k - 1; i++) {
            pk = pk * power % mod;
        }
        for (int i = n - 1; i >= 0; i--) {
            h = (h * power + (s[i] - 'a' + 1)) % mod;
            if (i <= n - k) {
                if (h == hashValue) {
                    first = i;
                }
                h = (h - pk * (s[i + k - 1] - 'a' + 1)) % mod;
                if (h < 0)
                    h += mod;
            }
        }
        return t.substring(first, first + k);
    }
}
