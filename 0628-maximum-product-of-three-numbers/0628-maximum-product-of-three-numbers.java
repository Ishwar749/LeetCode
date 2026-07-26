class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = -1000;
        int max2 = -1000;
        int max3 = -1000;
        int min1 = 1000;
        int min2 = 1000;

        for(int num: nums) {
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num > max2) {
                max3 = max2;
                max2 = num;
            }
            else {
                max3 = Math.max(max3, num);
            }

            if(num < min1) {
                min2 = min1;
                min1 = num;
            }
            else min2 = Math.min(min2, num);
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}