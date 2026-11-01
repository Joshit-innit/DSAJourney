class Solution {
    public int minMoves(int[] nums) {
        int minValue = Arrays.stream(nums).min().getAsInt();
        int moves = Arrays.stream(nums).map(num -> minValue - num).sum();
        return Math.abs(moves);
    }
}