class Solution {
    public int countServers(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int rowCount[] = new int[rowLength];
        int colCount[] = new int[colLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int count = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    if (rowCount[row] > 1 || colCount[col] > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}