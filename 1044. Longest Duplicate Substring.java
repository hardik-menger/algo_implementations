import java.util.*;

class L1044 {

    public String longestDupSubstring(String s) {
        int low = 0, high = s.length();
        String res = "";
        while (low <= high) {
            int mid = low + (high - low) / 2;
            String sub = check(s, mid);
            if (!sub.isEmpty()) {
                res = sub;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return res;
    }

    private String check(String S, int len) {
        long multipier = 256, hash = 0, p = (1 << 31) - 1, msbMultiplier = 1L;
        for (int j = 0; j < len; j++)
            hash = (multipier * hash + S.charAt(j)) % p;
        for (int i = 1; i < len; i++)
            msbMultiplier = (multipier * msbMultiplier) % p;
        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);
        for (int i = 1; i + len <= S.length(); i++) {
            hash = (hash + p - S.charAt(i - 1) * msbMultiplier % p) % p;
            hash = ((hash * multipier) % p + S.charAt(i + len - 1)) % p;
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            } else {
                for (int j : map.get(hash)) {
                    if (compare(S, i, j, len)) {
                        return S.substring(i, i + len);
                    }
                }
            }
            map.get(hash).add(i);
        }
        return "";
    }

    private boolean compare(String S, int i, int j, int len) {
        for (int count = 0; count < len; count++) {
            if (S.charAt(i++) != S.charAt(j++))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        L1044 obj = new L1044();
        System.out.println("ans    " + obj.longestDupSubstring("banana"));
        System.out.println("ans    " + obj.longestDupSubstring("zxcvdqkfawuytt"));
    }
}
