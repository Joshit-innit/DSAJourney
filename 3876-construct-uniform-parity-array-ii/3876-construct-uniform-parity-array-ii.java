class Solution {
    public boolean uniformArray(int[] nums1) {
        int minValue = nums1[0];
        boolean flag = false;
        for (int num : nums1) {
            minValue = Math.min(minValue, num);
            if ((num & 1) == 1) {
                flag = true;
            }
        }

        if ((minValue & 1) == 1) {
            return true;
        }

        return !flag;
    }
}