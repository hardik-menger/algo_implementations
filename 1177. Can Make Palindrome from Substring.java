import java.util.*;

class L1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] cnt = new int[s.length() + 1][26];
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            cnt[i + 1] = cnt[i].clone();
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        for (int[] q : queries) {
            int sum = 0;
            for (int i = 0; i < 26; i++)
                sum += ((cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2);
            ans.add(sum / 2 <= q[2]);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        L1177 obj = new L1177();
    }
}
