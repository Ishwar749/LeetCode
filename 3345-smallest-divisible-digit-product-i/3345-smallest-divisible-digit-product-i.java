class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i = 0; i <= 10; i++) {
            int cur = n + i;
            int pro = digitProduct(cur);
            if(pro % t == 0) return cur;
        }

        return n;
    }

    private int digitProduct(int x) {
        int product = 1;

        while(x > 0) {
            int dig = x % 10;
            product = product * dig;
            x = x / 10;
        }

        return product;
    }
}