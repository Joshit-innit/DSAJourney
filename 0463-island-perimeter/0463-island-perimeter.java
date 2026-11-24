class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    result +=4;

                    if (row > 0 && grid[row - 1][col] == 1) {
                        result--;
                    }
                    if (row < rows - 1 && grid[row + 1][col] == 1) {
                        result--;
                    }
                    if (col < cols - 1 && grid[row][col + 1] == 1) {
                        result--;
                    }
                    if (col > 0 && grid[row][col - 1] == 1) {
                        result--;
                    }
                } 
            }
        }

        return result;
        
    }
}