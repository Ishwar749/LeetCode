class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int len = nums.length;
        int answer = 0;

        for(int i = 0; i < len; i++) {
            int count = 0;
            for(int j = i; j < len; j++) {
                if(nums[j] == target) count++;
                if(count > ((j - i) + 1) / 2) answer++;
            }
        }

        return answer;
    }
}