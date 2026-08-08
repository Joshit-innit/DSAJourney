class Solution {
    long mod = 1000000007;
    public long power (long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = power(base, exp / 2);

        long ans = (half * half) % mod;
        if (exp % 2 == 1) {
            ans = (ans * (base % mod)) % mod;
        }

        return ans;
    }
    public int minNonZeroProduct(int p) {
        
        long max = (1L << p) - 1;
        long ans = power(max - 1, (max - 1) / 2);
        ans = (ans * (max % mod)) % mod;
        return (int)ans;

    }
}