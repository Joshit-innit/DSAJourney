class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                result = Math.max(result, count);
                count = (count - 1 < 0)?0:count - 1;
            }
        }
        return result;
    }
}