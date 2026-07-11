class Solution {
    public boolean canShip(int capacity, int[] weights, int days) {
        int currCapacity = capacity;
        int reqDays = 1;

        for (int weight : weights) {
            if (currCapacity - weight < 0) {
                reqDays++;    // if the weight exceed the capacity, we increase a day and reset the capacity.
                currCapacity = capacity;
            }
            currCapacity -= weight;
        }

        return reqDays<=days; // if the number of days are smaller than the given days we consider it.
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int left = Arrays.stream(weights).max().getAsInt(); // find the maximum of the array. This will be the minimum number of days to ship.
        int right = Arrays.stream(weights).sum(); // this will be the right (sum of the weights)
        int ans = Integer.MAX_VALUE;

        // we do a binary search on the maximum to totatSum
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canShip(mid, weights, days)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
}