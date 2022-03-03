import java.util.*;

class L1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean at[] = new boolean[26];
        for (char ch : allowed.toCharArray())
            at[ch - 'a'] = true;
        int count = 0;
        for (String word : words) {
            boolean c[] = new boolean[26];
            for (char ch : word.toCharArray())
                c[ch - 'a'] = true;
            for (int i = 0; i < at.length; i++) {
                if (c[i] == true && at[i] == false)
                    break;
                else if (i == at.length - 1)
                    count++;
            }

        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        L1684 obj = new L1684();
    }
}
