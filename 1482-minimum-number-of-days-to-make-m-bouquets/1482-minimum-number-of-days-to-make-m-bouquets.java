class Solution {
    public int boqueCount(int[] bloomDay, int k, int day) {
        int bloomed = 0;
        int boques = 0;

        for (int days : bloomDay) {
            if (days - day <= 0) {
                bloomed++;
            }else {
                boques += bloomed / k;
                bloomed = 0;
            }
        }
        boques += bloomed / k;

        return boques;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int flowers = bloomDay.length;
        if ((long)m * k > flowers) {
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int days : bloomDay) {
            left = Math.min(left, days);
            right = Math.max(right, days);
        }
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (boqueCount(bloomDay, k, mid) >= m) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

        }

        return ans;
    }
}