class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int[] take = new int[nums.length];
        int[] dont = new int[nums.length];
        
        take[start] = nums[start];
        
        for (int i = start + 1; i <= end; i++) {
            take[i] = nums[i] + dont[i - 1];
            dont[i] = Math.max(take[i - 1], dont[i - 1]);
        }

        return Math.max(take[end], dont[end]);
    }
}