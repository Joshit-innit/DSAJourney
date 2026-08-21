class Solution {
    public long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public long countOfMultiples(long x, int[] coins) {
        long count = 0;
        int bits = 0; // maximum of 15 bits only
        int n = coins.length;
        long mul = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            bits = 0;
            mul = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & ((1 << i))) != 0) {
                    bits++;
                    mul = lcm(mul, coins[i]);
                    if (mul > x) {
                        break;
                    }
                }
            }
            if (mul > x) {
                continue;
            }

            long totalNumbersDivisibleByMul = x / mul;
            count += (bits % 2 == 0) ? -totalNumbersDivisibleByMul : totalNumbersDivisibleByMul;
        }

        return count;

    }

    public long findKthSmallest(int[] coins, int k) {
        long left = 1;
        long right = (Arrays.stream(coins).min().getAsInt() * (long) k);

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countOfMultiples(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// [5, 3, 2]
// 001 010 011 100 101 110 111 - > generate these using bit masks, and calculate the multiplier and bits.
// if bits are even remove from count, if its odd add to count


// Pure maths problem count(n) = n / 2 + n / 3 + n / 5 - n / 2 * 5 - n / 3 * 5 - n / 2 * 3 + n / 2 * 3 * 5
// odd and even are odd ->[[2], [3], [5], [2, 3, 5]] even -> [[2, 5], [3, 5], [2, 3]]
