class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for (int nums[] : matrix) {
        //     for (int num : nums) {
        //         if (num == target) {
        //             return true;        ---> Brute Force O(n^2)
        //         }
        //     }
        // }
        // return false;

                    
                        
        //                 cols
        // rows ->[1,4,7,11,15]
        //        [2,5,8,12,19]
        //        [3,6,9,16,22]
        //        [10,13,14,17,24]
        //        [18,21,23,26,30]

        
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }
            else if (target > matrix[row][col]){
                row++;
            }
            else {
                col--;
            }
        }

        return false;
    }
}