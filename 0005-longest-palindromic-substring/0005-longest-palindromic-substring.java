class Solution {
    public int find (String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        int result  = 0;
        int n = s.length();
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int oddLength = find(s, i , i );
            int evenLength = find (s, i, i + 1);

            int maxLength = Math.max(oddLength, evenLength);

            if (maxLength > result) {
                result = maxLength;

                left = i - (maxLength - 1) / 2;
                right = i + maxLength / 2;
            }
        }
        return s.substring(left, right + 1);
    }
}