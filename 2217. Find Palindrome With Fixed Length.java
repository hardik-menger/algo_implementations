import java.util.*;

class L2217 {

    static long nthPalindrome(int n, int k) {
        long temp = (k & 1) != 0 ? (k / 2) : (k / 2 - 1);
        long palindrome = (int) Math.pow(10, temp);
        palindrome += n - 1;
        long firstHalf = (palindrome);
        if ((k & 1) > 0)
            palindrome /= 10;
        while (palindrome > 0) {
            firstHalf = firstHalf * 10 + (palindrome % 10);
            palindrome /= 10;
        }
        return firstHalf;
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long M = 1000000007;
        long[] answer = new long[queries.length];
        int j = 0;
        for (int i : queries) {
            answer[j++] = nthPalindrome(i, intLength);
            int length = getLength(answer[j - 1]);
            if (length >= intLength)
                answer[j - 1] = -1;
        }
        return answer;
    }

    int getLength(long number) {
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        L2217 obj = new L2217();
    }
}
