class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        if (n == 0) return 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;

            }
            set.add(ch);
            result = Math.max(result, right - left + 1);
        }
        return result;

    }
}