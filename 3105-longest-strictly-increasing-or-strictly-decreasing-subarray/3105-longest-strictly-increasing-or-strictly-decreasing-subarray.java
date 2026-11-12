class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incur = 1;
        int decur = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            incur = nums[i] > nums[i - 1]? ++incur: 1;
            decur = nums[i] < nums[i - 1]? ++decur: 1;
            result = Math.max(Math.max(incur, decur), result);
        }
        return result;
    }
}