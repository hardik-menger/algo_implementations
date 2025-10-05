import java.util.ArrayList;
import java.util.List;

public class test {
    class Solution {

        class TrieNode {
            public TrieNode[] nodes = new TrieNode[26];
            public boolean isEnd;
            public char c;

            TrieNode(char ch) {
                this.c = ch;
            }
        }

        class Trie {
            TrieNode root = new TrieNode('a');

            void insert(String word) {
                var node = root;
                for (char c : word.toCharArray()) {
                    if (node.nodes[c] == null) {
                        node.nodes[c] = new TrieNode(c);
                    }
                    node = node.nodes[c];
                }
                node.isEnd = true;
            }

            boolean isExisiting(TrieNode node, String word, int index, int count) {
                boolean res = false;
                if (count < 0)
                    return res;
                for (int i = 0; i < 26; i++) {
                    if (node.nodes[i] != null) {
                        if (i != word.charAt(index)) {
                            res |= isExisiting(node.nodes[i], word, index + 1, count - 1);
                        } else {
                            res |= isExisiting(node.nodes[i], word, index + 1, count);
                        }
                    }
                }
                return res;
            }
        }

        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            Trie trie = new Trie();
            for (var word : dictionary) {
                trie.insert(word);
            }
            var list = new ArrayList<String>();
            for (var query : queries) {
                if (trie.isExisiting(trie.root, query, 0, 2)) {
                    list.add(query);
                }
            }
            return list;
        }
    }
}
