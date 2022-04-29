import java.util.*;
import random.*;

class L889 {
    int pre = 0, post = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[pre++]);
        if (node.val != postorder[post])
            node.left = constructFromPrePost(preorder, postorder);
        if (node.val != postorder[post])
            node.right = constructFromPrePost(preorder, postorder);
        if (node.val == postorder[post])
            post++;
        return node;
    }

    public static void main(String[] args) throws Exception {
        L889 obj = new L889();
    }
}
