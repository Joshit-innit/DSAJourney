class Solution {
    public void findSubsets(int nums[], int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        if (target < 0 || nums.length == index || nums[index] > target) {
            return;
        }

        list.add(nums[index]);
        target -= nums[index];
        findSubsets(nums, target, index + 1, result, list);

        list.remove(list.size() - 1);
        target += nums[index];
        int next = index + 1;

        while (next < nums.length && nums[index] == nums[next]) {
            next++;
        }

        findSubsets(nums, target, next, result, list);

        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findSubsets(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
}