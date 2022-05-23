import java.util.*;
import random.*;

class L230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            k--;
            if (k == 0)
                return curr.val;
            curr = curr.right;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        L230 obj = new L230();
    }
}
