class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;
        int newHeights[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            newHeights[i] = heights[i];
        }

        newHeights[n] = 0;

        for (int i = 0; i < n + 1; i+=1) {

            int current = newHeights[i];

            while(!stack.isEmpty() && current < newHeights[stack.peek()]) {
                int index = stack.pop();
                int height = newHeights[index];
                int width = (stack.isEmpty() ? i : i - stack.peek() - 1);
                int area = height * width;
                maxArea = Math.max(area, maxArea);
                
            }


            stack.push(i);
        }

        return maxArea;
    }
}