class MyCalendar {

    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();    
    }
    
    public boolean book(int startTime, int endTime) {
        Integer low = map.floorKey(startTime);

        if (low != null && isOverlapping(low, map.get(low), startTime, endTime)) {
            return false;
        }

        Integer high = map.ceilingKey(startTime);
        if (high != null && isOverlapping(startTime, endTime, high, map.get(high))) {
            return false;
        }

        map.put(startTime, endTime);
        return true;
    }

    private boolean isOverlapping(int a, int b, int c, int d) {
        if (a < c && b <= c) return false;
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */