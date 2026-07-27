class Solution {
    public void permutation(int nums[], List<List<Integer>> result, boolean[] set, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set[i] == false) {
                set[i] = true;
                list.add(nums[i]);
                permutation(nums, result, set, list);
                set[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] set = new boolean[nums.length];
        permutation(nums, result, set, new ArrayList<>());
        return result;
    }
}