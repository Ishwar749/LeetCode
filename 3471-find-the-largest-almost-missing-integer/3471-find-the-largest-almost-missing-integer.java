class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int e: nums) freq.put(e, freq.getOrDefault(e, 0) + 1);

        if(k == 1) {
            int max = -1;
            for (int e: nums) if (freq.get(e) == 1) max = Math.max(max, e);
            return max;
        }
        else if(k == nums.length) {
            int max = -1;
            for (int e: nums) max = Math.max(max, e);
            return max;
        }
        else {
            int max = -1;
            int first = nums[0];
            int last = nums[nums.length - 1];
            if (freq.get(first) == 1) max = Math.max(max, first);
            if (freq.get(last) == 1) max = Math.max(max, last);
            return max;
        }
    }
}