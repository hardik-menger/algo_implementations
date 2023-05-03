import java.util.*;
import random.*;

class L105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return solve(hm, inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode solve(HashMap<Integer, Integer> hm, int[] inorder, int[] preorder, int istart, int iend,
            int pstart, int pend) {
        if (istart > iend || pstart > pend)
            return null;
        int rootData = preorder[pstart];
        TreeNode root = new TreeNode(rootData);
        int inIndex = hm.get(rootData);
        int subTreeSize = inIndex - istart;
        root.left = solve(hm, inorder, preorder, istart, inIndex - 1, pstart + 1, pstart + subTreeSize);
        root.right = solve(hm, inorder, preorder, inIndex + 1, iend, pstart + subTreeSize + 1, pend);
        return root;
    }

    public static void main(String[] args) throws Exception {
        L105 obj = new L105();
    }
}
