import java.util.*;

class L331 {

    public boolean isValidSerialization(String sa) {
        int count = 1;
        String[] s = sa.split(",");
        for (int i = 0; i < s.length; i++) {
            if (count == 0)
                return false;
            if (s[i].equals("#"))
                count--;
            else
                count++;
        }
        return count == 0;
    }

    public static void main(String[] args) throws Exception {
        L331 obj = new L331();
    }
}
