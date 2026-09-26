class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        int start = -1;
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                start = i;
            }
            else if (ch == ')') {
                String value = s.substring(start + 1, i);

                result.append(map.getOrDefault(value, "?"));
                start = -1;
            }
            else if (start == -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}