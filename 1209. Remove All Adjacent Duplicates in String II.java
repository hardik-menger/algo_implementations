import java.util.*;
import random.*;

class L1209 {

    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && (st.peek().p1 == ch)) {
                st.peek().p2++;
            } else {
                st.push(new Pair<Character, Integer>(ch, 1));
            }
            if (st.peek().p2 == k)
                st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            int noOfChars = st.peek().p2;
            char ch = st.pop().p1;
            while (noOfChars-- != 0)
                sb.insert(0, ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        L1209 obj = new L1209();
    }
}
