class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] min = new int[rows][cols];

        for (int[] row: min) Arrays.fill(row, Integer.MAX_VALUE);
        min[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> Integer.compare(a[2], b[2]));
        int[] start = {0, 0, 0};
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d: dir) {
                int row = d[0] + cur[0];
                int col = d[1] + cur[1];
                
                if (isValid(row, col, rows, cols)) {
                    int effort = (int)Math.abs(heights[row][col] - heights[cur[0]][cur[1]]);
                    effort = Math.max(effort, cur[2]);

                    if (effort < min[row][col]) {
                        min[row][col] = effort;
                        int[] toAdd = {row, col, effort};
                        queue.add(toAdd);
                    }
                }
            }
        }

        return min[rows - 1][cols - 1];
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        return true;
    }
}