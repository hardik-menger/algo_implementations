import java.util.*;

class L670 {

    public int maximumSwap1(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int min = -1, n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] < arr[i + 1] && min == -1) {
                min = i;
            } else if (min != -1 && arr[min] <= arr[i])
                min = i;
        }
        for (int i = 0; i < arr.length; i++) {
            if (min != -1 && min != i && arr[min] > arr[i]) {
                char temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        return Integer.valueOf(new String(arr));
    }

    public int maximumSwap(int num) {
        char[] c = Integer.toString(num).toCharArray();
        if (c.length == 1)
            return num;
        int mx = c.length - 1;
        int left = -1, right = -1;
        for (int i = c.length - 2; i >= 0; i--) {
            if (c[mx] == c[i])
                continue;
            if (c[mx] < c[i])
                mx = i;
            else {
                left = i;
                right = mx;
            }
        }
        if (left != -1 && right != -1) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
        }
        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) throws Exception {
        L670 obj = new L670();
    }
}
