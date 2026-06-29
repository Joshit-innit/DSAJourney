class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 0);
        for (int i = 0; i < n; i++) {
            int current = temperatures[i];

            while (!stack.isEmpty() && current > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }

            stack.push(i);
        }

        return ans;
    }
}