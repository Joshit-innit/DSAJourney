class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;

        }
        if (n <= 3) {
            return 2;
        }
        int maxIndex = -1;
        int minIndex = -1;

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
            if (nums[i] < minValue) {
                minValue = nums[i];
                minIndex = i;
            }
        }

        int index1 = Math.min(minIndex, maxIndex);
        int index2 = Math.max(minIndex, maxIndex);

        int dist1 = index1 + 1 + (n - index2 ); // delete from both the ends
        int dist2 = index2 + 1; // delete from left side
        int dist3 = n - index1; // delete from right side

        return Math.min(dist1, Math.min(dist2, dist3));


    }
}