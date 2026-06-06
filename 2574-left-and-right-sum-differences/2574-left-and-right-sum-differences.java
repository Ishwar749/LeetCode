class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] answer = new int[nums.length];

        int totalSum = 0;
        for(int e: nums) totalSum += e;

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            answer[i] = (int) Math.abs(totalSum - leftSum);
            leftSum += nums[i];
        }

        return answer;
    }
}