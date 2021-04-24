package Utils;

import java.util.*;

class Trie {
    class TreeNode {
        String word;
        HashMap<Character, TreeNode> children = new HashMap<>();
    }

    TreeNode root = new TreeNode();

    void add(String word) {
        TreeNode temp = root;
        for (char c : word.toCharArray()) {
            TreeNode node = temp.children.getOrDefault(c, null);
            if (node == null) {
                node = new TreeNode();
                temp.children.put(c, node);
            }
            temp = node;
        }
        temp.word = word;
    }

    boolean search(String word) {
        return searchUtil(word, 0, root);
    }

    private boolean searchUtil(String word, int i, TreeNode root) {
        if (i == word.length())
            return root.word != null;
        if (root.children.size() == 0)
            return false;
        if (!root.children.containsKey(word.charAt(i)))
            return false;
        return searchUtil(word, i + 1, root.children.get(word.charAt(i)));
    }
}
