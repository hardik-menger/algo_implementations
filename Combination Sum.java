import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allres = new ArrayList<>();
        List<Integer> tempres = new ArrayList<>();
        solve(candidates, target, allres, tempres, 0);
        return allres;
    }

    public void solve(int[] candidates, int target, List<List<Integer>> allres, List<Integer> res, int index) {
        if (target == 0) {
            allres.add(new ArrayList<Integer>(res));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if ((target - candidates[i]) >= 0) {
                res.add(candidates[i]);
                solve(candidates, target - candidates[i], allres, res, i);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(new CombinationSum().combinationSum(new int[] { 2, 3, 5 }, 8));
    }
}
