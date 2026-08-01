class Solution {
    public boolean predictTheWinner(int[] nums) {
        int total = 0;
        int[][][] dp = new int[nums.length][nums.length][2];

        for(int[][] grid: dp) {
            for(int[] row: grid) {
                Arrays.fill(row, -1);
            }
        }


        for(int e: nums) total += e;

        int score = findMaxScore(0, nums.length - 1, 1, nums, dp);
        int score2 = total - score;

        if(score >= score2) return true;
        return false;
    }

    private int findMaxScore(int i, int j, int turn, int[] nums, int[][][] dp) {
        if(i > j) {
            return 0;
        }

        if(dp[i][j][turn] != -1) return dp[i][j][turn];

        if(turn == 1) {
            return dp[i][j][turn] = Math.max(findMaxScore(i + 1, j, 0, nums, dp) + nums[i], findMaxScore(i, j - 1, 0, nums, dp) + nums[j]);
        }
        else {
            return dp[i][j][turn] = Math.min(findMaxScore(i + 1, j, 1, nums, dp), findMaxScore(i, j - 1, 1, nums, dp));
        }
    }
}