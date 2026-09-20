class Solution {
    public int reverseDegree(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int toAdd = (('a' - s.charAt(i)) + 26) * (i + 1);
            answer += toAdd;
        }

        return answer;
    }
}