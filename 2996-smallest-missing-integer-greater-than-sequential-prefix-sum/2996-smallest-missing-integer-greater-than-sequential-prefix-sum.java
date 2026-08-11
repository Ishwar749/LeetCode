class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int e: nums) set.add(e);

        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            }
            else break;
        }

        for (int j = sum; j <= 2600; j++) {
            if (!set.contains(j)) return j;
        }

        return sum;
    }
}