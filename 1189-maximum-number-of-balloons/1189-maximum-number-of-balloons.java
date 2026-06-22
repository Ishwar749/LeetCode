class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[5];

        for(int i = 0; i < text.length(); i++) {
            char cur = text.charAt(i);
            
            if(cur == 'b') freq[0]++;
            else if(cur == 'a') freq[1]++;
            else if(cur == 'l') freq[2]++;
            else if(cur == 'o') freq[3]++;
            else if(cur == 'n') freq[4]++;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 5; i++) {
            if(i == 2 || i == 3) min = Math.min(min, freq[i] / 2);
            else min = Math.min(min, freq[i]);
        }   

        return min;
    }
}