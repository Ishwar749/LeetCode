class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            nums[i] = ( nums[i] * nums[i] );
        }

        Arrays.sort(nums);

        int start = 0; 
        int end = len - 1;

        long answer = 0;

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                answer = answer + nums[end];
                end--;
            }
            else {
                answer = answer - nums[start];
                start++;
            }
        }

        return answer;
    }
}