import java.util.*;

class L1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<Integer, Set<String>> map = new TreeMap<Integer, Set<String>>();
        for (String word : words) {
            map.putIfAbsent(word.length(), new HashSet<String>());
            map.get(word.length()).add(word);
        }
        int res = 0;
        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            int target = length - 1;
            int best = 0;
            if (target >= 1) {
                Set<String> result = map.get(target);
                if (result != null) {
                    for (int i = 0; i < length; i++) {
                        String newString = word.substring(0, i) + word.substring(i + 1);
                        if (result.contains(newString)) {
                            best = Math.max(best, dp.getOrDefault(newString, 0) + 1);
                        }
                    }
                    dp.put(word, best);
                    res = Math.max(res, best);
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) throws Exception {
        L1048 obj = new L1048();
    }
}
