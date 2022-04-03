package Utils;

public class PatternMatchinZAlgorithm {
    public int[] calculateZ(char[] input) {
        int z[] = new int[input.length];
        int left = 0, right = 0;
        for (int k = 1; k < input.length; k++) {
            if (k <= right) {
                int j = k - left;
                if (z[j] < right - k + 1) {
                    z[k] = z[j];
                } else {
                    left = k;
                    while (right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    z[k] = right - left;
                    right--;
                }
            } else {
                left = right = k;
                while (right < input.length && input[right] == input[right - left]) {
                    right++;
                }
                z[k] = right - left;
                right--;
            }
        }
        return z;
    }
}
