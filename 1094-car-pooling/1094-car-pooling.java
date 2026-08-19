class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] cap = new int[1002];

        for (int[] trip: trips) {
            int from = trip[1];
            int to = trip[2];
            int pass = trip[0];

            cap[from] -= pass;
            cap[to] += pass;
        }

        for (int i = 0; i < 1002 && capacity >= 0; i++) capacity += cap[i];

        return capacity >= 0;

    }
}