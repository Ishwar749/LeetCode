class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int e: nums) max = Math.max(max, e);

        int answer = 0;
        for(int e: nums) answer = answer + (max-e);
        return answer;
    }
}