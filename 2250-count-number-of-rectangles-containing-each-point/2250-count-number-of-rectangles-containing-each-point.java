class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int n = rectangles.length;

        Arrays.sort(rectangles, (int[] r1, int[] r2) -> {
            if (r1[0] == r2[0]) return Integer.compare(r1[1], r2[1]);
            else return Integer.compare(r1[0], r2[0]);
        });

        int[][] dp = new int[n][101];

        for (int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= 100; j++) {
                if (i + 1 < n) {
                    dp[i][j] = dp[i + 1][j];
                }
                if (rectangles[i][1] >= j) {
                    dp[i][j] += 1;
                }
            }
        }


        int[] result = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int index = binarySearch(rectangles, point); 

            if (index == -1) result[i] = 0;
            else {
                result[i] = dp[index][point[1]];
            }
        }

        return result;
    }

    private int binarySearch(int[][] rectangles, int[] point) {
        int n = rectangles.length;
        int low = 0;
        int high = n - 1;
        int index = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (rectangles[mid][0] >= point[0]) {
                index = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return index;
    }
}