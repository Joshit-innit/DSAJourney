class Solution {
    List<List<Integer>> result;
    public void findSubSets(int index, int nums[], List<Integer> list) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length ; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            findSubSets(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        findSubSets(0, nums, new ArrayList<>());
        return result;
    }
}