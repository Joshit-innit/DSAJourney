class Solution {
    public boolean count(int radius, int[] houses, int[] heaters) {
        for (int house : houses) {
            int left = 0;
            int right = heaters.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (house > heaters[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            int minDiff = Integer.MAX_VALUE;

            if (left < heaters.length) {
                minDiff = Math.min(minDiff, Math.abs(heaters[left] - house));
            }
            if (left > 0) {
                minDiff = Math.min(minDiff, Math.abs(heaters[left - 1] - house));
            }

            if (minDiff > radius) {
                return false;
            }

        }
        return true;
    }
    public int findRadius(int[] houses, int[] heaters) {
        // Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Math.max(Arrays.stream(houses).max().getAsInt(), Arrays.stream(heaters).max().getAsInt());
        int ans = right;
        int len = houses.length;

        while(left <= right) {
            int radius = left + (right - left) / 2;
            if (count(radius, houses, heaters)) {
                ans = Math.min(ans, radius);
                right = radius - 1;
            }
            else {
                left = radius + 1;
            }
        }
        return ans;
    }
}