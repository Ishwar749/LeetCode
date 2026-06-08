class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int len = nums.length;

        int ind = 0;

        for(int i = 0; i < len; i++) {
            if(nums[i] < pivot) {
                ans[ind] = nums[i];
                ind++;
            }
        }
        for(int i = 0; i < len; i++) {
            if(nums[i] == pivot) {
                ans[ind] = nums[i];
                ind++;
            }
        }
        for(int i = 0; i < len; i++) {
            if(nums[i] > pivot) {
                ans[ind] = nums[i];
                ind++;
            }
        }

        return ans;
    }
}