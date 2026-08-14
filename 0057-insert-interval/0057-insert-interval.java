class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();
        int addedAt = -1;

        for (int i = 0; i < len; i++) {
            if (isOverlapping(intervals[i], newInterval)) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            else {
                if(newInterval[0] < intervals[i][0]) {
                    result.add(newInterval);
                    addedAt = i + 1;
                }
                
                result.add(intervals[i]);

                if(addedAt != -1) break;
            }
        }

        if(addedAt != -1) {
            for(int i = addedAt; i < len; i++) {
                result.add(intervals[i]);
            }
        }
        else {
            result.add(newInterval);
        }

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }

    private boolean isOverlapping(int[] a, int[] b) {
        if(a[0] <= b[0]) return b[0] <= a[1];
        else return a[0] <= b[1];
    }
}