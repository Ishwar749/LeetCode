class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for(int e: nums) {
            set.add(e);
            min = Math.min(min, e);
            max = Math.max(max, e);
        }

        List<Integer> result = new ArrayList<>();
        
        for(int i = min; i <= max; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}