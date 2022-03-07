import java.util.*;
import java.util.stream.Collectors;

class L2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        TreeMap<Long, List<Integer>> map = new TreeMap<Long, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            long mapped = mapnumber(String.valueOf(nums[i]), mapping);
            map.putIfAbsent(mapped, new ArrayList<Integer>());
            map.get(mapped).add(number);
        }
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (List<Integer> list : map.values())
            for (int i : list)
                sorted.add(i);
        return sorted.stream().mapToInt(Integer::intValue).toArray();
    }

    private long mapnumber(String s, int[] mapping) {
        if (s.equals("0"))
            return mapping[0];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            list.add(mapping[digit]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i);
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        L2191 obj = new L2191();
        System.out.println(Arrays
                .toString(obj.sortJumbled(new int[] { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 }, new int[] { 991, 338, 38 })));
        System.out.println(Arrays
                .toString(obj.sortJumbled(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8,
                        9 }, new int[] { 789, 456, 123 })));

        System.out.println(Arrays
                .toString(obj.sortJumbled(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8,
                        9 }, new int[] { 0, 999999999 })));
        System.out.println(Arrays
                .toString(obj.sortJumbled(new int[] { 7, 9, 4, 1, 0, 3, 8, 6, 2, 5 }, new int[] { 47799,
                        19021, 162535, 454, 95, 51890378, 404 })));

    }
}
