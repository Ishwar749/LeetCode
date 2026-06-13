class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        TreeMap<String, List<String>> groups = new TreeMap<>();

        for(String str: strs) {
            String key = getKey(str);
            groups.computeIfAbsent(key, k -> new ArrayList<>());
            groups.get(key).add(str);
        }

        for(String key: groups.keySet()) {
            result.add(groups.get(key));
        }

        return result;
    }

    private String getKey(String str) {
        int[] freq = new int[26];

        for(int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            freq[cur - 'a']++;
        }

        StringBuilder key = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                char c = (char)('a' + i);
                key.append(c);
                key.append(freq[i]);                
            }
        }

        return key.toString();
    }
}