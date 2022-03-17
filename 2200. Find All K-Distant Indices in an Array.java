import java.util.*;

class L2200 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((Math.abs(i - j) <= k) && nums[j] == key) {
                    result.add(i);
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;

    }

    public static void main(String[] args) throws Exception {
        L2200 obj = new L2200();
    }
}
