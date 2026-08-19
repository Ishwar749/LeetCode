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

        for (int i = 1; i < 1002; i++) cap[i] += cap[i - 1];

        Arrays.sort(trips, (int[] a, int[] b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int[] trip: trips) {
            if(cap[trip[1]] + capacity < 0) return false;
        }

        return true;
    }
}