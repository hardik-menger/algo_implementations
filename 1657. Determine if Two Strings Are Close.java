import java.util.*;

class L1667 {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
        for (int i = 0; i < word1.length(); i++) {
            c1[word1.charAt(i) - 'a']++;
            set1.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            c2[word2.charAt(i) - 'a']++;
            set2.add(word2.charAt(i));
        }
        if (!set1.equals(set2))
            return false;
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        L1667 obj = new L1667();
        System.out.println(obj.closeStrings("abc", "cba"));
        System.out.println(obj.closeStrings("a", "aa"));
        System.out.println(obj.closeStrings("cabbba", "abbccc"));
        System.out.println(obj.closeStrings("abbzzca", "babzzcz"));
    }
}
