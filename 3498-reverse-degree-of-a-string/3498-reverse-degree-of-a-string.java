class Solution {
    public int reverseDegree(String s) {
        int result = 0;
        int i = 1;
        for (char ch : s.toCharArray()) {
            result += i * (26 - ((int)ch - 97) );
            i++;
        }
        return result;
    }
}