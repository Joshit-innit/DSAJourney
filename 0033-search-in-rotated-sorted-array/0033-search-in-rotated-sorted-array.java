class Solution {
    public int search(int[] nums, int target) {
        int ans = 0;
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        // while(left <= right) {
        //     int mid = left + (right - left) / 2;

        //     if (nums[mid] == target) {
        //         return mid;
        //     }else if (mid < n - 1 && nums[mid + 1] < target) {
        //         left = mid + 1;
        //     }else if (mid > 0 && nums[mid - 1] < target){
        //         right = mid - 1;
        //     }
        // }

        // return -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        return -1;
    }
}