class Solution {
    public boolean backtrack(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }

        boolean matched = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            return (backtrack(s, p, i, j + 2) || (matched && backtrack(s, p, i + 1, j)));
        }
        if (matched) {
            return backtrack(s, p, i + 1, j + 1);
        }

        return false;
    }
    public boolean isMatch(String s, String p) {
        return backtrack(s, p, 0, 0);
    }
}