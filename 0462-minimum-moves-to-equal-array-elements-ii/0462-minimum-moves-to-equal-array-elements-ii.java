class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort (nums);
        int median = nums[nums.length / 2];
        return Arrays.stream(nums)
                    .map(num -> Math.abs(num - median))
                    .sum();

    }
}