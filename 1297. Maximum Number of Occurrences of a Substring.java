import java.util.*;

class L1297 {

    public int maxFreq1(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            String sub = s.substring(i, i + minSize);
            Set<Character> repeat = new HashSet<>();
            for (char c : sub.toCharArray())
                repeat.add(c);
            if (repeat.size() <= maxLetters) {
                res = Math.max(res, map.getOrDefault(sub, 0) + 1);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        return res;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character, Integer> runningCount = new HashMap<>();
        int res = 0;
        HashMap<String, Integer> result = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            runningCount.put(s.charAt(i), runningCount.getOrDefault(s.charAt(i), 0) + 1);

            if (i - start + 1 > minSize) {
                int count = runningCount.get(s.charAt(start));
                runningCount.put(s.charAt(start), runningCount.get(s.charAt(start)) - 1);
                if (count == 0)
                    runningCount.remove(s.charAt(start));
                start++;
            }
            if (i - start + 1 == minSize && runningCount.size() <= maxLetters) {
                int val = runningCount.getOrDefault(s.substring(start, i + 1), 0) + 1;
                result.put(s.substring(start, i + 1), val);
                res = Math.max(res, val);
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        L1297 obj = new L1297();
        System.out.println(obj.maxFreq("aababcaab", 2, 3, 4));

    }
}
