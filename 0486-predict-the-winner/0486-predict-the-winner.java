class Solution {
    public boolean predictTheWinner(int[] nums) {
        int total = 0;
        for(int e: nums) total += e;

        int score = findMaxScore(0, nums.length - 1, 1, nums);
        int score2 = total - score;

        if(score >= score2) return true;
        return false;
    }

    private int findMaxScore(int i, int j, int turn, int[] nums) {
        if(i > j) {
            return 0;
        }

        if(turn == 1) {
            return Math.max(findMaxScore(i + 1, j, 0, nums) + nums[i], findMaxScore(i, j - 1, 0, nums) + nums[j]);
        }
        else {
            return Math.min(findMaxScore(i + 1, j, 1, nums), findMaxScore(i, j - 1, 1, nums));
        }
    }
}