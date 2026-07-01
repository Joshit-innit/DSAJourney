class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = m - 1; 
        int col = 0;

        // Start from the bottom left corner
        // You cannot start from the top right corner as u dont gain any information
        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                count += n - col; // if you see an negative number count the elements
                row--; // as you saw the negative element go up
            }
            else {
                col++; // As you didnt see the negative number, move util u find the next negative number
            }
        }
        return count;
    }
}
