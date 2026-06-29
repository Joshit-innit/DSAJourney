class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int result[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int current = heights[i];

            int visible = 0;
            while(!stack.isEmpty() && current > heights[stack.peek()]) {
                visible++;
                stack.pop();
            }

            if(!stack.isEmpty()) visible++;

            result[i] = visible;
            stack.push(i);
        }

        return result;
    }
}