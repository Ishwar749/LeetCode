class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        char mid = '-';
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            int times = freq[i] / 2;
            for(int j = 0; j < times; j++) {
                answer.append((char)('a' + i));
            }

            if(freq[i] % 2 == 1) mid = (char)('a' + i);
        }

        if(mid != '-') {
            answer.append(mid);
        }

        for(int i = 25; i >= 0; i--) {
            int times = freq[i] / 2;
            for(int j = 0; j < times; j++) {
                answer.append((char)('a' + i));
            }
        }

        return answer.toString();
    }
}