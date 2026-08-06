class Solution {
    long MOD = 1000000007;
    public long pow(long base, long exp) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2);

        long ans = (half * half) % MOD;

        if (exp % 2 == 1) {
            ans = (ans * base) % MOD;
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }

        long primes = n / 2;
        long even = (n+1)/2;

        return (int)((pow(5, even) * pow (4, primes)) % MOD);
    }
}