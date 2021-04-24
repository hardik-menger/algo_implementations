import java.util.*;

class WordSearchII {
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

    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words)
            trie.add(word);
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                dfs(board, i, j, res, trie.root);
        return res;
    }

    private void dfs(char[][] board, int i, int j, ArrayList<String> res, Trie.TreeNode root) {
        char c = board[i][j];
        Trie.TreeNode resNode = root.children.get(c);
        root = root.children.get(c);
        if (resNode == null || root == null || c == '#')
            return;
        if (resNode != null && resNode.word != null) {
            res.add(resNode.word);
            resNode.word = null;
        }
        board[i][j] = '#';
        if (i > 0)
            dfs(board, i - 1, j, res, root);
        if (j > 0)
            dfs(board, i, j - 1, res, root);
        if (i < board.length - 1)
            dfs(board, i + 1, j, res, root);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, res, root);
        board[i][j] = c;
    }
}
