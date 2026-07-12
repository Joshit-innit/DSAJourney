class Solution {
    public long distribution(int[] candies, int mid) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
        }
        return count;
    }
    public long sum(int[] nums) {
        long total = 0;
        for (int n : nums) total +=n;
        return total ;
    }
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = Arrays.stream(candies).max().getAsInt();
        long totalSum = sum(candies);
        
        int ans = left;
        if (totalSum < k) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(distribution(candies, mid) >= k) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
}