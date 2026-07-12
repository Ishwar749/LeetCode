class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(!tm.containsKey(arr[i])) tm.put(arr[i], new ArrayList());
            tm.get(arr[i]).add(i);
        }

        int[] ans = new int[arr.length];
        int rank = 1;

        for(int key: tm.keySet()) {
            for(int index: tm.get(key)) {
                ans[index] = rank;
            }
            rank++;
        }
        
        return ans;
    }
}