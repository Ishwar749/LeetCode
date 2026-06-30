class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1, b = -1, c = -1;

        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') a = i;
            else if(s.charAt(i) == 'b') b = i;
            else c = i;

            int start = Math.min(a, Math.min(b, c));
            if(start != -1) {
                answer += (start+1);
            }
        }

        return answer;
    }
}