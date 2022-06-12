import java.util.*;

class L205 {

    public boolean isIsomorphic(String s, String t) {

        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        L205 obj = new L205();
        System.out.println(obj.isIsomorphic("egg", "add"));
        System.out.println(obj.isIsomorphic("foo", "bar"));

    }
}
