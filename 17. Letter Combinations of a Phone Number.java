import java.util.*;
import random.*;

class L17 {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        if (digits.isEmpty())
            return ret;
        combination(new StringBuilder(), digits, 0, ret);
        return ret;
    }

    private void combination(StringBuilder prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix.toString());
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix.append(letters.charAt(i)), digits, offset + 1, ret);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        L17 obj = new L17();
    }
}
