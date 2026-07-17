class Solution {
    
    public long maxRunTime(int n, int[] batteries) {
        long left = 1;
        long right = Arrays.stream(batteries).asLongStream().sum() / n;
        
        long ans = -1;
        while (left <= right) {
            long T = left + (right - left) / 2;
            long availableEnergy = 0;
            for (int t : batteries) {
                availableEnergy += Math.min((long)t, T); 
            }

            if (availableEnergy >= (long)n * T) {
                ans = T;
                left = T + 1;
            }else {
                right = T - 1;
            }
        }
        return ans;
    }
}