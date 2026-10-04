class Solution {
    static int[][][] dp;

    public boolean checkValidString(String s) {
        int len = s.length();
        dp = new int[len][len][len];

        for (int[][] matrix: dp) {
            for (int[] row: matrix) {
                Arrays.fill(row, -1);
            }
        }
        
        return checkValidString(0, s, 0, 0);
    }

    private boolean checkValidString(int i, String s, int open, int closed) {
        if (i == s.length()) {
            if (open == closed) return true;
            return false;
        }

        if (closed > open) return false;

        if (dp[i][open][closed] != -1) {
            if (dp[i][open][closed] == 1) return true;
            return false;
        }

        char cur = s.charAt(i);
        boolean result = false;

        if (cur == '(') {
            result = checkValidString(i + 1, s, open + 1, closed);
        }
        else if (cur == ')') {
            result = checkValidString(i + 1, s, open, closed + 1);
        }
        else {
            result = checkValidString(i + 1, s, open, closed);
            result |= checkValidString(i + 1, s, open + 1, closed);
            result |= checkValidString(i + 1, s, open, closed + 1);
        }

        dp[i][open][closed] = result ? 1 : 0;
        return result;
    }
}