class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int [] b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 1;
        int low = intervals[0][0];
        int high = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(!(low <= intervals[i][0] && intervals[i][1] <= high)) {
                count++;
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }

        return count;
    }
}