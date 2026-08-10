class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder s = new StringBuilder();


        for (int i = 0; i < pattern.length() + 1; i++) {
            stack.push(i + 1);


            while (!stack.isEmpty() && (i == pattern.length() || pattern.charAt(i) == 'I')) {
                s.append(stack.pop());
            }
        }

        return s.toString();
    }
}