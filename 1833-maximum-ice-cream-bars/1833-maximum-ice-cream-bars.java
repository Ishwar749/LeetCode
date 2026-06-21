class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        
        int max = Integer.MIN_VALUE;
        for(int cost: costs) max = Math.max(max, cost);

        int[] freq = new int[max + 1];

        for(int i = 0; i < n; i++) {
            freq[costs[i]]++;
        }

        int count = 0;

        for(int i = 1; i < freq.length; i++) {
            int quotient = coins / i;
            int min = Math.min(freq[i], quotient);
            coins -= (min*i);
            count += min;
            if(coins == 0) break;
        }

        return count;
    }
}