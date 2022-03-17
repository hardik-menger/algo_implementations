import java.util.*;
import java.util.stream.Collectors;

class L1347 {
    public int minSteps(String s, String t) {
        char sArray[] = s.toCharArray(), tArray[] = t.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : sArray)
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : tArray)
            map.put(c, map.getOrDefault(c, 0) - 1);
        return map.values().stream().filter(e -> e > 0).collect(Collectors.summingInt(Integer::intValue));
    }

    public static void main(String[] args) throws Exception {
        L1347 obj = new L1347();
    }
}
