class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxPrefix[] = new int[n];
        int minPrefix[] = new int[n];
        maxPrefix[0] = nums[0];
        minPrefix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(nums[i], maxPrefix[i - 1]);

            minPrefix[n - 1 - i] = Math.min(nums[n - 1 - i], minPrefix[n - i]);
        }

        for (int i = 0; i < n; i++) {
            if (maxPrefix[i] - minPrefix[i] <= k) {
                return i;
            }
        }

        return -1;

        
        
    }
}