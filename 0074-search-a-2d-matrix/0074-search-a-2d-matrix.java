class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        int top = 0;
        int bottom = rows;
        int row = -1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;

            if (matrix[mid][cols] < target) {
                top = mid + 1;
            } 
            else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            }
            else {
                row = mid;
                break;
            }
        }

        if (row == -1) return false;


        int left = 0;
        int right = cols;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(matrix[row][mid] > target) {
                right = mid - 1;

            }else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}