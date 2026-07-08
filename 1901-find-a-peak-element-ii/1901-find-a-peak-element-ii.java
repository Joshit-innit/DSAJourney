class Solution {
    public int maxColIndex(int mat[][] , int row, int cols) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int col = 0; col < cols; col++) {
            if (mat[row][col] > max) {
                index = col;
                max = mat[row][col];
            }
        }

        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = rows - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int MaxElementColIndex = maxColIndex(mat, mid, cols);
            int upElement = (mid > 0)?mat[mid - 1][MaxElementColIndex]:Integer.MIN_VALUE;
            int downElement = (mid < rows - 1)?mat[mid + 1][MaxElementColIndex]:Integer.MIN_VALUE;


            if (mat[mid][MaxElementColIndex] > upElement && mat[mid][MaxElementColIndex] > downElement  ) {
                return new int[]{mid, MaxElementColIndex};
            }
            else if (upElement > mat[mid][MaxElementColIndex]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }


        }

        return new int[]{-1 ,-1};



        // find the maximum element in the row, as it is the maximum element the left and the right will be minimul of the maximum.
        
        // After finding the maximum value, check the up and down element of the maximum element. And handle the edges as well(lines 25, 26)
        // If the up and down are small, return the [row][maxElementColumn];
        // If the up element is grater than maxElement move up (high = mid - 1)
        // If the down element is greater than maxElement move down (low = mid + 1)
    }
}