class Solution {

    static List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generateParenthesis(n, sb, 0, 0);
        return result;
    }

    private void generateParenthesis(int n, StringBuilder sb, int open, int closed) {
        if (open == n && closed == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            generateParenthesis(n, sb, open + 1, closed);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closed < open) {
            sb.append(')');
            generateParenthesis(n, sb, open, closed + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}