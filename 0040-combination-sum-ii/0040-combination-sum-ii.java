class Solution {
    public void comboSum(int nums[], int target, int index, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index == nums.length || nums[index] > target) {
            return;
        }

        list.add(nums[index]);
        target -= nums[index];
        comboSum(nums, target, index + 1, list, result);

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        list.remove(list.size() - 1);
        target += nums[index];
        comboSum(nums, target, next, list, result);
        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        comboSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}