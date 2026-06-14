class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie[] tries = new Trie[strs.length];

        for(int i = 0; i < strs.length; i++) {
            tries[i] = new Trie();
            tries[i].insert(strs[i]);
        }

        StringBuilder lcp = new StringBuilder();

        for(int i = 0; i < strs[0].length(); i++) {
            lcp.append(strs[0].charAt(i));

            for(Trie trie: tries) {
                if(!trie.startsWith(lcp.toString())) {
                    return lcp.substring(0, lcp.length() - 1).toString();
                }
            }
        }

        return lcp.toString();
    }

    public class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for(char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }

            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;

            for(char c: word.toCharArray()) {
                node = node.children.get(c);
                if(node == null) return false;
            }

            return node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;

            for(char c: prefix.toCharArray()) {
                node = node.children.get(c);
                if(node == null) return false;
            }

            return true;
        }
    }
}