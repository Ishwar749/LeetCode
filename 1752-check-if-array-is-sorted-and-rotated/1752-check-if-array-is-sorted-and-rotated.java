class Solution {
    public boolean check(int[] nums) {
       int len = nums.length;
        int start = 0;

       for(int i = 0; i < len - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                start = i + 1;
            }
       }

       for(int i = 0; i < len - 1; i++) {
            if(nums[(i + start) % len] > nums[(i + 1 + start) % len]) return false;
       }

       return true;
    }
}