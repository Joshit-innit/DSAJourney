class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }
}