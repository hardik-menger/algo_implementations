import java.util.*;

class L1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        sc1 = sort(sc1);
        sc2 = sort(sc2);
        int count1 = 0, count2 = 0;
        for (int i = 0; i < sc1.length; i++) {
            if (sc1[i] > sc2[i])
                count1++;
            else if (sc1[i] < sc2[i])
                count2++;
            else {
                count2++;
                count1++;
            }
        }
        return count1 == sc1.length || count2 == sc2.length;
    }

    public boolean checkIfCanBreak1(String s1, String s2) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        sc1 = sort(sc1);
        sc2 = sort(sc2);
        int count1 = 0, count2 = 0;
        for (int i = 0; i < sc1.length; i++) {
            if (sc1[i] > sc2[i])
                count1++;
            else if (sc1[i] < sc2[i])
                count2++;
            else {
                count2++;
                count1++;
            }
        }
        return count1 == sc1.length || count2 == sc2.length;
    }

    char[] sort(char arr[]) {
        int n = arr.length;
        char output[] = new char[n];
        int count[] = new int[256];
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        return output;
    }

    public static void main(String[] args) throws Exception {
        L1433 obj = new L1433();
        System.out.println(obj.checkIfCanBreak("abc", "xya"));
        System.out.println(obj.checkIfCanBreak("abe", "acd"));
        System.out.println(obj.checkIfCanBreak("leetcodee", "interview"));
    }
}
