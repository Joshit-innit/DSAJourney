class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}