import java.util.*;

class L2195 {

    public long minimalKSum1(int[] nums, int k) {
        Arrays.sort(nums);
        long a = 0;
        long smallnumber = 1;
        while (k != 0 && nums[0] > smallnumber) {
            a += smallnumber;
            k--;
            smallnumber++;

        }

        for (int i = 0; i < nums.length - 1; i++) {
            long additor = 1;
            while ((nums[i] + additor) < nums[i + 1]) {
                if (k == 0)
                    break;
                a += (nums[i] + additor);
                additor++;
                k--;

            }
        }

        long largenumber = nums[nums.length - 1] + 1;
        while (k != 0) {
            a += (largenumber++);
            k--;
        }
        return a;
    }

    public long minimalKSum(int[] nums, int k) {
        long mostOptimalAnswer = 0;
        Arrays.sort(nums);
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : nums) {
            if (!hs.contains(i) && i <= k) {
                mostOptimalAnswer += i;
                k++;
            }
            hs.add(i);
        }
        return (k * (k + 1L) / 2) - mostOptimalAnswer;
    }

    public static void main(String[] args) throws Exception {
        L2195 obj = new L2195();
        System.out.println(obj.minimalKSum(new int[] { 1, 4, 25, 10, 25 }, 2));
        System.out.println(obj.minimalKSum(new int[] { 5, 6 }, 6));
    }
}
