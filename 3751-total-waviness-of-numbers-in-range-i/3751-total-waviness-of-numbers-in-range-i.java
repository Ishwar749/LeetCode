class Solution {
    public int totalWaviness(int num1, int num2) {
         int total = 0;
        for(int i = num1; i <= num2; i++) {
            total += findWaves(i);
        }

        return total;
    }

    static int findWaves(int x) {
        String s = x+"";

        if(s.length() < 3) return 0;

        int count = 0;

        for(int i = 1; i < s.length() - 1; i ++) {
            char c = s.charAt(i);
            char p = s.charAt(i-1);
            char n = s.charAt(i+1);

            if(c > p && c > n) count++;
            if(c < p && c < n) count++;
        }

        return count;
    }
}