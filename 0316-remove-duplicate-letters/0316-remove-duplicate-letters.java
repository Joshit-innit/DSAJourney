class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int lastIndex[] = new int[26];
        boolean inStackStatus[] = new boolean[26];
        int n = s.length();
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);

            if (inStackStatus[current - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && current < stack.peek() && lastIndex[stack.peek() - 'a'] > i) {
                inStackStatus[stack.pop() -  'a'] = false;
            }

            inStackStatus[current -'a'] = true;
            stack.push(current);
        }



        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}