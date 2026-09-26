class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> know = new HashMap<>();
        
        for(List<String> pair: knowledge) {
            String key = pair.get(0);
            String value = pair.get(1);
            know.put(key, value);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean isKey = false;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '(') {
                isKey = true;
                continue;
            }

            if (isKey) {
                if (cur == ')') {
                    result.append(know.getOrDefault(key.toString(), "?"));
                    key = new StringBuilder();
                    isKey = false;
                }
                else {
                    key.append(cur);
                }
            }
            else {
                result.append(cur);
            }
        }

        return result.toString();
    }
}