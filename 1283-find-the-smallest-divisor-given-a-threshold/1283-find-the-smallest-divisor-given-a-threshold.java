class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int sum = 0;
            for (int num : nums) {
                sum += ((num + mid - 1) / mid);
            }
            if (sum <= threshold) {
                ans = Math.min(mid, ans);
                right = mid - 1;
            }
            else  {
                left = mid + 1;
            }
           
        }
        return ans;
    }
}