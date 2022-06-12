import java.util.*;

class L1915 {

    public long wonderfulSubstrings(String word) {
        int count[] = new int[1024];
        int res = 0;
        count[0] = 1;
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask ^= 1 << word.charAt(i) - 'a';
            res += count[mask];
            for (int j = 0; j < 10; j++) {
                res += count[mask ^ (1 << j)];
            }
            count[mask]++;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        L1915 obj = new L1915();
        System.out.println(obj.wonderfulSubstrings("aabb"));
    }
}
