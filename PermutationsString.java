import java.util.ArrayList;
import java.util.List;

class PermutationsString {
    String s;

    public List<String> permute(String st) {
        List<String> res = new ArrayList<>();
        int i = 0;
        s = st;
        solve(res, i);
        return res;
    }

    private void solve(List<String> res, int i) {
        if (i == s.length() - 1) {
            res.add(s);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            swap(i, j);
            solve(res, i + 1);
            swap(i, j);
        }
    }

    private void swap(int i, int j) {
        char ch[] = s.toCharArray();
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
        s = new String(ch);
    }

    public static void main(String args[]) {
        System.out.println((new PermutationsString().permute("abc")));
    }
}
