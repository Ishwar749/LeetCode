class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min( solve(landStartTime, landDuration, waterStartTime, waterDuration), 
                         solve(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    private int solve(int[] ride1, int[] dur1, int[] ride2, int[] dur2) {

        int finish1 = Integer.MAX_VALUE;

        for(int i = 0; i < ride1.length; i++) {
            finish1 = Math.min(finish1, ride1[i] + dur1[i]);
        }

        int finish2 = Integer.MAX_VALUE;

        for(int i = 0; i < ride2.length; i++) {
            finish2 = Math.min(finish2, Math.max(finish1, ride2[i]) + dur2[i]);
        }

        return finish2;
    }
}