class Solution {
    public String minWindow(String s, String t) {

        int lenS = s.length();
        int lenT = t.length();

        int start = 0;
        int end = 0;
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();
        
        int lenResult = 1000000;
        int resStart = -1;
        int resEnd = -1;

        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        while(end < lenS) {
            char cur = s.charAt(end);
            freqS.put(cur, freqS.getOrDefault(cur, 0) + 1);


            while (start <= end && containsAll(freqS, freqT)) {
                int curLen = (end - start) + 1;

                if (curLen < lenResult) {
                    lenResult = curLen;
                    resStart = start;
                    resEnd = end;
                }
                decrement(freqS, s.charAt(start));
                start++;
            }
            
            end++;
        } 

        if (lenResult == 1000000) return "";
        return s.substring(resStart, resEnd + 1);  
    }

    private boolean containsAll(Map<Character, Integer> freqS, Map<Character, Integer> freqT) {
        for (Character key: freqT.keySet()) {
            if (!freqS.containsKey(key) || freqS.get(key) < freqT.get(key)) return false;
        }
        return true;
    }

    private void decrement(Map<Character, Integer> map, Character key) {
        map.put(key, map.get(key) - 1);

        if (map.get(key) == 0) map.remove(key);
    }
}