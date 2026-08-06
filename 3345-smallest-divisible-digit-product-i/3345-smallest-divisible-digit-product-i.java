class Solution {
    public int productOfNumber(int number) {
        int product = 1;

        while (number > 0) {
            product *= number % 10;
            number /= 10;
        }

        return product;
    }
    public int smallestNumber(int n, int t) {
        for (int i = n; i < n + t; i++) {
            if (productOfNumber(i) % t == 0) {
                return i;
            }
        }
        return -1;
    }
}