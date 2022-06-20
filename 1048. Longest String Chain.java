import java.util.*;

class L1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            int best = 0;
            for (int i = 0; i < length; i++) {
                String newString = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(newString, 0) + 1);

            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        L1048 obj = new L1048();
    }
}
