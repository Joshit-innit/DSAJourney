class Solution {
    public long numberOfCars(int ranks[], long time) {
        long cars = 0;
        for (int rank : ranks) {
            cars += (long)Math.sqrt((double)time / rank);
        }

        return cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long)Arrays.stream(ranks).min().getAsInt() * cars * cars;
        long result = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (numberOfCars(ranks, mid) >= cars) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}