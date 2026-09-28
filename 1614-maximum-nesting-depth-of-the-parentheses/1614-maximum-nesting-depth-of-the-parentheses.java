class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
                max = Math.max(max, open);
            }
            else if (s.charAt(i) == ')') open--;
        }

        return max;
    }
}