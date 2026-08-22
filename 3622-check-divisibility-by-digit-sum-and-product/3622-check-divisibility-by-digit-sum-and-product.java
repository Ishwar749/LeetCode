class Solution {
    public boolean checkDivisibility(int n) {

        int m = n;
        int digSum = 0;
        int product = 1;

        while (m > 0) {
            int dig = m % 10;
            digSum += dig;
            product *= dig;
            m = m / 10;
        }

        int total = digSum + product;

        return (n % total) == 0;
    }
}