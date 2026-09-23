class Solution {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int maxLengthSubArray = -1;
        int currentSum = 0;
        int n = nums.length;
        while (right < n) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == target) {
                maxLengthSubArray = Math.max(maxLengthSubArray, right - left + 1);
            }
            right++;
        }

        return (maxLengthSubArray == -1)?-1:n - maxLengthSubArray;
    }
}