class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int dir[][] = {
            {0,1},{1,0},{-1,0},{0,-1}
        };
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
                else{
                    grid[i][j] =-1;
                }
            }
        }
        while(!queue.isEmpty()) {
            int sizeQueue = queue.size();
            for(int i = 0; i < sizeQueue; i++) {
                int[] current = queue.poll();
                int rCurrent = current[0];
                int cCurrent = current[1];
                for (int[] d: dir) {
                    int rNew = rCurrent + d[0];
                    int cNew = cCurrent + d[1];
                    if (rNew >= 0 && rNew < rows && cNew >=0 && cNew < columns && grid[rNew][cNew] == -1) {
                        grid[rNew][cNew] = grid[rCurrent][cCurrent] + 1;
                        queue.add(new int[]{rNew, cNew});
                    }

                }
            }
        }

        return grid;
    }
}