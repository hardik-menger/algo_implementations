import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], new ArrayList<>());
                hm.get(nums[i]).add(i);
            } else {
                hm.get(nums[i]).add(i);
            }
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                if (nums[i] != (target - nums[i]))
                    return new int[] { hm.get(nums[i]).get(0), hm.get(target - nums[i]).get(0) };
                else {
                    if (hm.get(nums[i]).size() >= 2)
                        return new int[] { hm.get(nums[i]).get(0), hm.get(target - nums[i]).get(1) };

                }
            }
        }
        return new int[] { -1, -1 };
    }
}
