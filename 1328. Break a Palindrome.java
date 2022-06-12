import java.util.*;

class L1328 {

    public String breakPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        if (ch.length >= 2 && ch[0] == ch[ch.length - 1] && ch[ch.length - 1] == 'a') {
            ch[ch.length - 1] = 'b';
            return String.valueOf(ch);
        }
        if (ch.length < 2)
            return "";
        return "";
    }

    public static void main(String[] args) throws Exception {
        L1328 obj = new L1328();
    }
}
