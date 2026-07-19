class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> seq = new Stack<>();
        Map<Character, Integer> last = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            last.put(cur, i);
        }

        boolean[] vis = new boolean[26];
        
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);

            if (vis[cur - 'a']) continue;
            
                char seqLast = seq.isEmpty() ? '*' : seq.peek();
                while (!seq.isEmpty() && seqLast > cur && last.get(seqLast) > i) {
                    char removed = seq.pop();
                    vis[removed - 'a'] = false;
                    
                    if (seq.isEmpty()) break;
                    else seqLast = seq.peek();
                }

                seq.push(cur);
                vis[cur - 'a'] = true;
            
        }

        StringBuilder result = new StringBuilder();

        while(!seq.isEmpty()) {
            result.append(seq.pop());
        }

        return result.reverse().toString();
    }
}