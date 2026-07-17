class Solution {
    public long GCD(long a, long b) {
        return (b == 0)? a : GCD(b, a % b);
    }
    public long LCM(long a, long b) {
        return (a / GCD(a, b)) * b;
    }
    public long NumberOfUglyNumbers(long a, long b, long c,long mid) {
        long count = 0;
        count += mid / a + mid / b + mid / c;
        count -= mid / LCM(a, b) + mid / LCM(b, c) + mid / LCM(c, a);
        count += mid / LCM(LCM(a, b), c);

        return count;
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1;
        long right = 2_000_000_000;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (NumberOfUglyNumbers(a, b, c, mid) < (long)n) {
                left = mid + 1;
            }
            else {
                ans = mid;
                right = mid - 1;
            }
        }
        return (int)ans;
    }
}