class Solution {
    public boolean isPossible(int[] nums, int maxOperations, int maximumBallsInOneBag) {
        int operations = 0;

        for (int num : nums) {
            operations += (int) Math.ceil((double) num / maximumBallsInOneBag) - 1;
            if (operations > maxOperations) {
                return false;
            }

        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int ans = right;
        while (left <= right) {
            int maximumBallsInOneBag = left + (right - left) / 2;

            if (isPossible(nums, maxOperations, maximumBallsInOneBag)) {
                ans = maximumBallsInOneBag;
                right = maximumBallsInOneBag - 1;
            } else {
                left = maximumBallsInOneBag + 1;
            }
        }
        return ans;
    }
}