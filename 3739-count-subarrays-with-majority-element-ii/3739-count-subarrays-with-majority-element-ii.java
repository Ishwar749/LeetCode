class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int prefixSum = n + 1;
        long[] count = new long[2 * n + 2];
        long[] preSumCount = new long[2 * n + 2]; // Prefix Sum for Count Array
        long res = 0L;

        count[prefixSum] = preSumCount[prefixSum] = 1;

        for(int e : nums) {
            prefixSum += (e == target? 1 : -1);
            count[prefixSum]++;
            preSumCount[prefixSum] = count[prefixSum] + preSumCount[prefixSum - 1];
            res += preSumCount[prefixSum - 1];
        }

        return res;
    }
}