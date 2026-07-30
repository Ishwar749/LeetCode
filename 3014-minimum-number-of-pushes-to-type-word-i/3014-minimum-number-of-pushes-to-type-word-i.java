class Solution {
    public int minimumPushes(String word) {
        
        int[] freq = new int[26];

        for(char c: word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int answer = 0;
        int mul = 1;
        int key = 2;

        for(int i = 25; i >= 0; i--) {
            answer = answer + (freq[i] * mul);
            System.out.println(answer);
            key++;
            if(key == 10) {
                key = 2;
                mul++;
            }
        }

        return answer;
    }
}