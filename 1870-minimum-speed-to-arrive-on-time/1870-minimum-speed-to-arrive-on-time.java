class Solution {
    public double TimeTaken(int[] dist, int speed) {
        int n = dist.length;
        double time = 0;
        for (int i = 0; i < n - 1; i++){
            time += (double)Math.ceil((double)dist[i] / speed);
        }
        time += (double)dist[n-1] / speed;
        return time ;
        
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10_000_000;
        int minSpeed = Integer.MAX_VALUE;

        while (left <= right) {
            int speed = left + (right - left) / 2;

            double time = TimeTaken(dist, speed);

            if (time <= hour) {
                minSpeed = Math.min(minSpeed, speed);
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }
        return (minSpeed == Integer.MAX_VALUE)?-1:minSpeed;
    }
}