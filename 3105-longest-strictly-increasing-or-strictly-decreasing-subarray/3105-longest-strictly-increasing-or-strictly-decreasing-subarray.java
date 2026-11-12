class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incur = 1;
        int decur = 1;
        int current = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                incur++;
            }else {
                incur = 1;
            }

            if (nums[i - 1] < nums[i]) {
                decur++;
            }
            else {
                decur = 1;
            }
            result = Math.max(Math.max(incur, decur), result);

        }


        return result;
    }
}