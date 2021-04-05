import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Permutations {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve1(res, temp, nums);
        return res;
    }

    private void solve1(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i : nums) {
            if (!temp.contains(i)) {
                temp.add(i);
                solve1(res, temp, nums);
                temp.remove(temp.indexOf(i));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        solve(nums, res, i);
        return res;
    }

    private void solve(int[] nums, List<List<Integer>> res, int i) {
        if (i == nums.length - 1) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int k : nums)
                al.add(k);
            res.add(al);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            solve(nums, res, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.deepToString((new Permutations().permute(new int[] { 1, 2, 3 })).toArray()));
    }
}
