class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int last[] = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean inStackStatus[] = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);

            if (inStackStatus[current - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && current < stack.peek() && last[stack.peek() - 'a'] > i) {
                inStackStatus[stack.pop() - 'a'] = false;
            }

            stack.push(current);
            inStackStatus[current - 'a'] = true;
        }


        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}