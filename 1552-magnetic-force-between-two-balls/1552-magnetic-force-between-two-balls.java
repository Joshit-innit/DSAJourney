class Solution {
    public boolean CountBalls(int[] buckets, int dist, int balls) {
        int LastBucketIndex = 0;
        int n = buckets.length;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (buckets[i] - buckets[LastBucketIndex] >= dist) {
                LastBucketIndex = i;
                count++;
            }
        }
        return count >= balls;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = Arrays.stream(position).max().getAsInt() - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int dist = left + (right - left) / 2;

            if (CountBalls(position, dist, m)) {
                ans = dist;
                left = dist + 1;
            }else {
                right = dist - 1;
            }
        }
        return ans;
    }
}