class Solution {
    List<List<String>> result;
    public void solve(int col, char[][] board,int leftRow[], int lowerDiagonal[], int upperDiagonal[], int n) {
        if (col == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            result.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && upperDiagonal[n - 1 + col - row] == 0 && lowerDiagonal[row+col] == 0) {
                leftRow[row] = 1;
                upperDiagonal[n-1+col-row] = 1;
                lowerDiagonal[row+col] = 1;
                board[row][col] = 'Q';
                solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, n);
                leftRow[row] = 0;
                upperDiagonal[n-1+col-row] = 0;
                lowerDiagonal[row+col] = 0;
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n - 1];
        int[] upperDiagonal = new int[2*n - 1];
        int intitialCol = 0;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i+=1) {
            Arrays.fill(board[i], '.');
        }
        solve(intitialCol, board, leftRow, lowerDiagonal, upperDiagonal, n);
        return result;
    }
}