import java.util.*;

class L1247 {

    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == 'x' && ch2[i] == 'y')
                xy++;
            else if (ch2[i] == 'x' && ch1[i] == 'y')
                yx++;
        }
        if ((xy + yx) % 2 == 0)
            return -1;
        int res = xy / 2;
        res += yx / 2;
        if (xy % 2 == 1)
            res += 2;
        return res;
    }

    public static void main(String[] args) throws Exception {
        L1247 obj = new L1247();
    }
}
