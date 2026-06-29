class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && digit < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        int i = 0;
        while(i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        String ans = result.substring(i);
        return ans.isEmpty()? "0": ans;
    }
}