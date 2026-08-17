class Solution {
    public int calculate(String s) {
        int sign = 1;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int currentNumber = 0;


        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                currentNumber = s.charAt(i) - '0';
                while (i < n -1 && Character.isDigit(s.charAt(i + 1))) {
                    currentNumber = currentNumber * 10 + s.charAt(i +1) - '0';
                    i++;
                }
                currentNumber *=  sign;
                ans += currentNumber;
                sign = 1;
                currentNumber = 0; 
            }
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                ans *= prevSign;
                int prevAns = stack.pop();
                ans += prevAns; 
            }
        }
        return ans;
    }
}