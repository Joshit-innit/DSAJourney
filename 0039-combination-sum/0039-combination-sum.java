class Solution {
    public void CombinationSum(int nums[], int index, int target, int length, List<List<Integer>> result, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if (index == length) {
                result.add(new ArrayList<>(list));
                return;
            }
            
        }
        if (index == length) {
            return;
        }
        target -= nums[index];
        list.add(nums[index]);
        CombinationSum(nums, index, target, length, result, list);

        list.remove(list.size() - 1);
        target += nums[index];
        
        CombinationSum(nums, index + 1, target, length, result, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        CombinationSum(candidates, 0, target, length, result, new ArrayList<>());
        return result;
    }
}