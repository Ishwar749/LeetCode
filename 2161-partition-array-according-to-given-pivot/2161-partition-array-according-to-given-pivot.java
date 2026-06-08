class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int less = 0;
        int greater = nums.length - 1;

        for(int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if(nums[i] < pivot) {
                ans[less] = nums[i];
                less++;
            }
            if(nums[j] > pivot) {
                ans[greater] = nums[j];
                greater--;
            }
        }

        while(less <= greater) {
            ans[less] = pivot;
            less++;
        }

        return ans;
    }
}