class Solution {
    public int minimumDeletions(int[] nums) {
        int size = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minInd = Integer.MAX_VALUE;
        int maxInd = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minInd = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
        }

        int answer = Integer.MAX_VALUE;
        min = Math.min(minInd, maxInd);
        max = Math.max(minInd, maxInd);

        // LL : Delete both from Left
        answer = Math.min(answer, max + 1);

        // LR: Delete min from Left and max from right
        answer = Math.min(answer, (min + 1) + (size - max));

        // RL: Delete min from Right and max from Left
        answer = Math.min(answer, size - min);

        // RR: Delete both from right
        answer = Math.min(answer, size - min);

        return answer;   
    }
}