class Solution {
    public char repeatedCharacter(String s) {
        boolean set[] = new boolean[26];
        char result = 'a';
        for (char ch : s.toCharArray()) {
            if (set[ch - 'a']) {
                result = ch;
                break;
            }
            set[ch - 'a'] = true;
        }
        return result;
    }
}