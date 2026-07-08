class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid < n - 1 && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            }
            else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            }
            else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}