class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] reserved = new int[n + 1];

        for(int[] booking: bookings) {
            int start = booking[0] - 1;
            int end = booking[1];
            int seats = booking[2];

            reserved[start] += seats;
            reserved[end] -= seats;
        }

        for (int i = 1; i <= n; i++) {
            reserved[i] += reserved[i - 1];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = reserved[i];

        return answer;
    }
}