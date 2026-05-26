class Solution {
    public int numberOfSpecialChars(String word) {
        int[] capitals = new int[26];

        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(cur >= 'A' && cur <= 'Z') {
                capitals[cur - 'A']++;
            }
        }

        // cur = 'C'
        // int index = 'C' - 'A'

        int answer = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(cur >= 'a' && cur <= 'z') {
                if(capitals[cur-'a'] > 0 && !set.contains(cur)) {
                    answer++;
                    set.add(cur);
                }
            }
        }

        return answer;
    }
}