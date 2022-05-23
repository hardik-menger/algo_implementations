import java.util.*;
import random.*;
import random.TreeNode;

class L1530 {
    int result = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    private int[] dfs(TreeNode root, int distance) {
        if (root == null)
            return new int[distance + 1];
        if (root.left == null && root.right == null) {
            int res[] = new int[distance + 1];
            res[1]++;
            return res;
        }
        int left[] = dfs(root.left, distance);
        int right[] = dfs(root.right, distance);
        for (int i = 0; i < left.length; i++)
            for (int j = 0; j <= distance - 1; j++) {
                if (i + j <= distance)
                    result += left[i] * right[j];
            }
        int res[] = new int[distance + 1];
        for (int i = res.length - 2; i >= 1; i--) {
            res[i + 1] = left[i] + right[i];
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        L1530 obj = new L1530();
    }
}
