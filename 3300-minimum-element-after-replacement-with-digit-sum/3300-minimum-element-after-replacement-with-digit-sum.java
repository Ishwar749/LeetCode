class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int num: nums) {
            min = Math.min(min, getSum(num));
        }

        return min;
    }

    private int getSum(int digit) {
        int sum = 0;

        while(digit > 0) {
            int dig = digit % 10;
            sum += dig;
            digit /= 10;
        }

        return sum;
    } 
}