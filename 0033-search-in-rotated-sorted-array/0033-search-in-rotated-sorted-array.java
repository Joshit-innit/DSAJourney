class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // left Sorted 
                if (nums[left] <= target && target < nums[mid]) {
                    // If the the target is in this range nums[left]<=target<nums[mid]. We dont need to check the right so we move towards the left part;
                    right = mid - 1;
                }
                else {
                    // if the target is not in the range of nums[left]<=target<nums[mid]. We dont need to check the left so we move towards the right part;
                    left = mid + 1;
                }
            }
            else {
                // Right sorted part
                if (nums[mid] < target && target <= nums[right]) {
                    // if the target is in this range nums[mid]<target<=nums[right]. We dont need to check the left part so we the right part;
                    left = mid + 1;
                }
                else {
                    // if the target is not in the range num[mid]<target<=nums[right]. We dont nee to check the right part so we move towards left;
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}