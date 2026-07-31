class Solution {

    public void bfs(char grid[][], boolean visited[][], int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });
        visited[startRow][startCol] = true;
        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        while (!queue.isEmpty()) {
            int Current[] = queue.poll();
            int rCurrent = Current[0];
            int cCurrent = Current[1];

            for (int[] dir : directions) {
                int rNew = rCurrent + dir[0];
                int cNew = cCurrent + dir[1];

                if (rNew >= 0 && rNew < rows && cNew >= 0 && cNew < cols && !visited[rNew][cNew]
                        && grid[rNew][cNew] == '1') {
                    visited[rNew][cNew] = true;
                    queue.offer(new int[] { rNew, cNew });
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];

        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
        
    }
}
