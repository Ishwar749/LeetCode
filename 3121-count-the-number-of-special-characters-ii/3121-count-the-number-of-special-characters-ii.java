class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lo = new int[26];
        int[] up = new int[26];
        Arrays.fill(up, -1);
        Arrays.fill(lo, -1);

        int len = word.length();

        for(int i = 0; i < len; i++) {
            char cur = word.charAt(i);
            if(cur >= 'a' && cur <= 'z') lo[cur - 'a'] = i;
            else if(up[cur - 'A'] == -1) up[cur - 'A'] = i;
        }

        int answer = 0;

        for(int i = 0; i < 26; i++) {
            if((lo[i] != -1 && up[i] != -1) && (lo[i] < up[i])) answer++;
        }

        return answer;
    }
}