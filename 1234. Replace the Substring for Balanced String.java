import java.util.*;

class L1234 {

    public int balancedString(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.putIfAbsent('Q', 0);
        map.putIfAbsent('W', 0);
        map.putIfAbsent('E', 0);
        map.putIfAbsent('R', 0);
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        int left = 0, n = s.length(), k = n / 4, res = n;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            while (left < n && map.get('Q') <= k && map.get('W') <= k && map.get('E') <= k && map.get('R') <= k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                res = Math.min(res, right - left + 1);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        L1234 obj = new L1234();
    }
}
