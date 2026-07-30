class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValidPosition(board, row, col, digit)) {
                            board[row][col] = digit;

                            if (solve(board) == true) {
                                return true;
                            }
                            else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidPosition(char[][] board, int row, int col, char currentDigit) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == currentDigit) return false;
            if (board[row][i] == currentDigit) return false;
            if (board[3* (row / 3) + i / 3][3 * (col / 3) + i % 3] == currentDigit) return false;
        }
        return true;
    }
}