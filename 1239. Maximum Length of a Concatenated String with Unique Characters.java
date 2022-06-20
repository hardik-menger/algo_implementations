import java.util.*;
import random.*;

class L1239 {
    int res = 0;

    public int maxLength(List<String> arr) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < arr.size(); i++) {
            set.clear();
            if (!hasDistinct(arr.get(i), set))
                continue;
            for (int j = 0; j < arr.get(i).length(); j++)
                set.add(arr.get(i).charAt(j));
            res = Math.max(res, set.size());
            check(arr, i + 1, set);
        }
        return res;
    }

    private void check(List<String> arr, int index, Set<Character> set) {
        for (int i = index; i < arr.size(); i++) {
            if (hasDistinct(arr.get(i), set)) {
                for (int j = 0; j < arr.get(i).length(); j++)
                    set.add(arr.get(i).charAt(j));
                res = Math.max(res, set.size());
                check(arr, i + 1, set);
                for (int j = 0; j < arr.get(i).length(); j++)
                    set.remove(arr.get(i).charAt(j));
            }
        }
    }

    private boolean hasDistinct(String string, Set<Character> set) {
        HashSet<Character> distinct = new HashSet<Character>();
        for (char c : string.toCharArray())
            distinct.add(c);
        if (distinct.size() != string.length())
            return false;
        for (int i = 0; i < string.length(); i++)
            if (set.contains(string.charAt(i)))
                return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        L1239 obj = new L1239();
        System.out.println(obj.maxLength(Arrays.asList(new String[] { "aa", "bb" })));
        System.out.println(obj.maxLength(Arrays.asList(new String[] { "un", "iq", "ue" })));
        System.out.println(obj.maxLength(Arrays.asList(new String[] { "cha", "r", "act", "ers" })));
        System.out.println(obj.maxLength(Arrays.asList(new String[] { "abcdefghijklmnopqrstuvwxyz" })));
    }
}
