class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;

        for(int e: gain) {
            sum += e;
            max = Math.max(sum, max);
        }

        return max;
    }
}