class Solution {
    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int[] index = {0};

        while (index[0] < s.length()) {
            char cur = s.charAt(index[0]);

            if (cur == '(') {
                String rev = reverseParentheses(s, index);
                result.append(rev);
            }
            else {
                result.append(cur);
                index[0]++;
            }
        }

        return result.toString();
    }

    private String reverseParentheses(String s, int[] index) {
        StringBuilder result = new StringBuilder();
        index[0]++;

        while (index[0] < s.length() && s.charAt(index[0]) != ')') {
            char cur = s.charAt(index[0]);
            if (cur == '(') {
                String rev = reverseParentheses(s, index);
                result.append(rev);
            }
            else {
                result.append(cur);
                index[0]++;
            }
            
        }
        index[0]++;

        return result.reverse().toString();
    }
}