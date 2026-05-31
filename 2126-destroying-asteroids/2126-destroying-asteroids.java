class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m = (long) mass;

        TreeMap<Long, Integer> tm = new TreeMap<>();

        for(int a: asteroids) {
            tm.put((long)a, tm.getOrDefault((long)a, 0) + 1);
        }

        while(!tm.keySet().isEmpty() && tm.floorKey(m) != null) {
            long toAdd = tm.floorKey(m);

            tm.put(toAdd, tm.get(toAdd) - 1);
            if(tm.get(toAdd) == 0) tm.remove(toAdd);

            m += toAdd;
        }

        if(tm.keySet().isEmpty()) return true;
        return false;
    }
}