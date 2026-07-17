class Solution {
    public long availableEnergy(int[] batteries, long T) {
        long available = 0;
        for (long t : batteries) {
            available += Math.min(t, T);
        }
        return available;
    }
    public long maxRunTime(int n, int[] batteries) {
        long left = 1;
        long right = Arrays.stream(batteries).asLongStream().sum() / n;
        
        long ans = -1;
        while (left <= right) {
            long T = left + (right - left) / 2;

            if (availableEnergy(batteries, T) >= (long)n * T) {
                ans = T;
                left = T + 1;
            }else {
                right = T - 1;
            }
        }
        return ans;
    }
}