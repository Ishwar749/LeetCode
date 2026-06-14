class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Trie trie = new Trie();
        
        for(String str: strs) {
            trie.insert(str);
        }

        return trie.searchLongestPrefix(strs[0]);
    }

    public class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }

        public int getChildren() {
            return children.keySet().size();
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

        public String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            for(char c: word.toCharArray()) {
                TrieNode child = node.children.get(c);
                if(child != null && node.getChildren() == 1 && !node.isEndOfWord) {
                    prefix.append(c);
                    node = child;
                }
                else return prefix.toString();
            }

            return prefix.toString();
        }
    }
}