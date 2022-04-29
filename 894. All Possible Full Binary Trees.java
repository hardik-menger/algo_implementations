import java.util.*;
import random.*;

class L894 {
    public List<TreeNode> allPossibleFBT(int n) {
        HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
        return recursive(n, map);
    }

    public List<TreeNode> recursive(int n, HashMap<Integer, List<TreeNode>> map) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        List<TreeNode> al = new ArrayList<TreeNode>();
        al.add(new TreeNode());
        if (n == 1)
            return al;
        if (map.containsKey(n))
            return map.get(n);
        al = new ArrayList<TreeNode>();
        for (int l = 0; l < n; l++) {
            int r = n - 1 - l;
            List<TreeNode> left = recursive(l, map);
            List<TreeNode> right = recursive(r, map);
            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {
                    al.add(new TreeNode(0, nodeL, nodeR));
                }
            }
        }
        map.put(n, al);
        return al;
    }

    public static void main(String[] args) throws Exception {
        L894 obj = new L894();
    }
}
