class Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int n = Integer.toBinaryString(num).length();

        int mask = 1 << n;
        mask = mask - 1;
        return mask ^ num;
    }
}