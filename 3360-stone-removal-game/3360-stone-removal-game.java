class Solution {
    public boolean canAliceWin(int n) {
        if (n < 10) {
            return false;
        }
        if (n == 10) {
            return true;
        }
        n -= 10;
        int remove = 9;
        int moves = 0;
        while (n >= remove) {
            n -= remove;
            remove--;
            moves++;
        }

        return moves % 2 == 0;


    }
}