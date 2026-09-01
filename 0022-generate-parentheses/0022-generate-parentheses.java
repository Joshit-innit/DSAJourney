class Solution {
    public void backtrack(StringBuilder sb, List<String> result, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            backtrack(sb.append("("), result, open+1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            backtrack(sb.append(")"), result, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(),result, 0, 0, n);
        return result;
    }
}