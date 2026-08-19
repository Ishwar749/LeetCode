class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, boolean[]> reserved = new HashMap<>();

        for (int[] r: reservedSeats) {
            int row = r[0];
            int seat = r[1];

            if (!reserved.containsKey(row)) reserved.put(row, new boolean[11]);

            reserved.get(row)[seat] = true;
        }

        int canSeatTwo = n - reserved.keySet().size();
        canSeatTwo += canSeatTwo;
        int total = canSeatTwo;

        for (int row : reserved.keySet()) {

            boolean[] seats = reserved.get(row);

            if(!seats[2] && !seats[3] && !seats[4] && !seats[5]) {
                total += 1;
                seats[2] = true;
                seats[3] = true;
                seats[4] = true;
                seats[5] = true;
            }
            if(!seats[4] && !seats[5] && !seats[6] && !seats[7]) {
                total += 1;
                seats[4] = true;
                seats[5] = true;
                seats[6] = true;
                seats[7] = true;
            }
            if(!seats[6] && !seats[7] && !seats[8] && !seats[9]) {
                total += 1;
                seats[6] = true;
                seats[7] = true;
                seats[8] = true;
                seats[9] = true;
            }
        }

        return total;
    }
}