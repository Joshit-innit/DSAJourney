class Solution {
    public int GCD(int a, int b) {
        return (b == 0)? a : GCD(b, a % b);
    }
    public int findGCD(int[] nums) {
        int minEle = nums[0];
        int maxEle = nums[0];

        for (int num : nums) {
            minEle = Math.min(num, minEle);
            maxEle = Math.max(num, maxEle);

        }

        return GCD(minEle, maxEle);
    }
}