class Solution {
    public int smallestIndex(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (i == getDigitSum(nums[i])) {
                return i;
            }
        }

        return -1;
    }

    private int getDigitSum(int x) {
        int sum = 0;

        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }

        return sum;
    }
}