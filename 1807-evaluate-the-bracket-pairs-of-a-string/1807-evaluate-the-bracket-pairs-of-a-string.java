class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                result.append(map.getOrDefault(s.substring(i + 1, j ), "?"));
                i = j ;

            }
            else {
                result.append(ch);
            }


        }

        return result.toString();
    }
}