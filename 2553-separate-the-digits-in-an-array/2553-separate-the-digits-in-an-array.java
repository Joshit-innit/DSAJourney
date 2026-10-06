class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(String.valueOf(num));
        }
        String s = sb.toString();
        int n = s.length();
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            result[i] = ch - '0';
        }
        return result;
    }
}