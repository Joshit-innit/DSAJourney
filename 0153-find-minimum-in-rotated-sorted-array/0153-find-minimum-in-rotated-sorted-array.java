class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[left] <= nums[mid]) {
                // the left half is sorted in ascending order, so pick the left most element and find the minimum and move towards right
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            }
            else {
                // the right half is sorted in ascending order, so pick the first element which is nums[mid] and move towards left
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }

        return ans;
    }
}
