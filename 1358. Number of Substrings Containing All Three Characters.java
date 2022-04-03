import java.util.*;

class L1358 {

    public int numberOfSubstrings(String s) {
        int i = 0, count = 0;
        int counts[] = new int[3];
        for (int j = 0; j < s.length(); j++) {
            if (counts[0] == 0 || counts[1] == 0 || counts[2] == 0)
                counts[s.charAt(j) - 'a']++;
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                counts[s.charAt(i++) - 'a']--;
            }
            count += i;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L1358 obj = new L1358();
        System.out.println(obj.numberOfSubstrings("aaacb"));
        System.out.println(obj.numberOfSubstrings("abcabc"));
    }
}
