import java.util.*;

class L2135 {

    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set = new HashSet<>();
        for (String start : startWords) {
            char[] sAr = start.toCharArray();
            Arrays.sort(sAr);
            set.add(new String(sAr));
        }

        int result = 0;
        for (String word : targetWords) {
            char[] tAr = word.toCharArray();
            Arrays.sort(tAr);
            int k = tAr.length;
            String s = String.valueOf(tAr);
            for (int j = 0; j < k; j++) {
                String str = s.substring(0, j) + s.substring(j + 1);
                if (set.contains(str)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        L2135 obj = new L2135();
        System.out
                .println(obj.wordCount(new String[] { "ant", "act", "tack" }, new String[] { "tack", "act", "acti" }));
    }
}
