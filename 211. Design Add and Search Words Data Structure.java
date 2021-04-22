class DesignAddSearchWordsDataStructure {
    public class WordDictionary {
        private class TrieNode {
            private boolean isWord;
            private HashMap<Character, TrieNode> childMap;

            public TrieNode() {
                isWord = false;
                childMap = new HashMap<Character, TrieNode>();
            }
        }

        private TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (!curr.childMap.containsKey(word.charAt(i))) {
                    curr.childMap.put(word.charAt(i), new TrieNode());
                }
                curr = curr.childMap.get(word.charAt(i));
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return searchHelper(root, 0, word);
        }

        private boolean searchHelper(TrieNode node, int pos, String word) {
            if (pos == word.length())
                return node.isWord;
            if (node.childMap.size() == 0)
                return false;
            if (word.charAt(pos) == '.') {
                for (char c : node.childMap.keySet()) {
                    if (searchHelper(node.childMap.get(c), pos + 1, word))
                        return true;
                }
            }
            if (!node.childMap.containsKey(word.charAt(pos)))
                return false;
            return searchHelper(node.childMap.get(word.charAt(pos)), pos + 1, word);
        }
    }
}
