import java.util.*;

class L670 {
    public int maximumSwap(int num) {
        char[] c = Integer.toString(num).toCharArray();
        int mx = c.length - 1;
        int left = -1, right = -1;
        for (int i = c.length - 2; i >= 0; i--) {
            if (c[mx] < c[i])
                mx = i;
            else {
                left = i;
                right = mx;
            }
        }
        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;
        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) throws Exception {
        L670 obj = new L670();
    }
}
