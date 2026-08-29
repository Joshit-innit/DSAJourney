class Solution {
    List<String> result;
    public void find(String s, int index, StringBuilder sb, int n) {
        if (index == n ) {
            result.add(sb.toString());
            return;
        }

        if ((s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') || (s.charAt(index) >= 'a' && s.charAt(index) <= 'z')) {
            find(s, index+1, sb.append(Character.toLowerCase(s.charAt(index))), n);
            sb.deleteCharAt(sb.length() - 1);
            find(s, index+1, sb.append(Character.toUpperCase(s.charAt(index))), n);
            sb.deleteCharAt(sb.length() - 1);
        }else {
            find(s, index+1, sb.append(s.charAt(index)), n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        result = new ArrayList<>();

        find(s, 0, new StringBuilder(), n);

        return result;
    }
}