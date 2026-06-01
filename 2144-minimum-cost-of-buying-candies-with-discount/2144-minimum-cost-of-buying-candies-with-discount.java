class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int minCost = 0;
        int isFree = 2;

        for(int i = cost.length - 1; i >= 0; i--) {
            if(isFree == 0) {
                isFree = 2;
                continue;
            }
            else {
                minCost += cost[i];
                isFree--;
            }
        }

        return minCost;
    }
}