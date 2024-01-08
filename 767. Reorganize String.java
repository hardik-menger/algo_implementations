import java.util.*;
import random.*;

class L767 {
    public String reorganizeString(String s) {
        int[] freq = new int[26]; // to Store Frequency of each alphabet
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) { // store the frequency
            freq[arr[i] - 'a']++;
        }

        int max = 0, letter = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }

        if (max > (s.length() + 1) / 2)
            return "";
        int idx = 0;
        char[] res = new char[s.length()];

        while (freq[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            freq[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= s.length())
                    idx = 1;
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }

        }

        return String.valueOf(res);
    }

    public static void main(String[] args) throws Exception {
        L767 obj = new L767();
    }
}
