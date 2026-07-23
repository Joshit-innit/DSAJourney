class Solution {
    public void findSubsets(int nums[], int index, int len, List<List<Integer>> result, List<Integer> list) {
        if (index == len) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        findSubsets(nums, index + 1, len, result, list);

        list.remove(list.size() - 1);
        findSubsets(nums, index + 1, len, result, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        findSubsets(nums, 0, len, result, new ArrayList<>());
        return result;

    }
}