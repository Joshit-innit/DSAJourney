class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long ans = Long.MIN_VALUE;
        for (int peek = 0; peek < n; peek++) {
            long sum = heights[peek];

            int prev = heights[peek];

            // go from left <---- peek 
            for (int i = peek - 1; i >= 0; i--) {
                prev = Math.min(prev, heights[i]);
                sum += prev;
            }


            prev = heights[peek];


            // go from peek ----> right
            for (int i = peek + 1; i < n; i++) {
                prev = Math.min(prev, heights[i]);
                sum += prev;
            }

            ans = Math.max(ans, sum);
        }

        return ans;

    }
}