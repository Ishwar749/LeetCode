class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        
        TreeMap<Integer, Integer> result = new TreeMap<>();

        for(int[] interval: series1) {
            int index = findInterval(interval[0], series2);
            int toAdd = index == -1? 0 : series2[index][1];

            result.put(interval[0], interval[1] + toAdd);
        }

        for(int[] interval: series2) {
            int index = findInterval(interval[0], series1);
            int toAdd = index == -1? 0 : series1[index][1];

            result.put(interval[0], interval[1] + toAdd);
        }


        List<List<Integer>> resultList = result.entrySet().stream()
                .map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return resultList;
    }

    private int findInterval(int time, int[][] series) {

        int low = 0;
        int high = series.length - 1;

        int index = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(series[mid][0] >= time) {
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