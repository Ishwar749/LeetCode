class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;

        while(n > 0) {
            int dig = n % 10;
            n = n / 10;
            if(dig > max1) {
                max2 = max1;
                max1 = dig;
            }
            else max2 = Math.max(max2, dig);
        }

        return max1 * max2;
    }
}