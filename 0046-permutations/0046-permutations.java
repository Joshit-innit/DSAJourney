class Solution {
    // public void permutation(int nums[], List<List<Integer>> result, boolean[] set, List<Integer> list) {
    //     if (list.size() == nums.length) {
    //         result.add(new ArrayList<>(list));
    //         return;
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         if (set[i] == false) {
    //             set[i] = true;
    //             list.add(nums[i]);
    //             permutation(nums, result, set, list);
    //             set[i] = false;
    //             list.remove(list.size() - 1);
    //         }
    //     }
    // }
    public void Permutations(int index, int nums[], List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            Permutations(index + 1, nums, result);
            swap(index, i, nums);
        }
        return;
    }
    public void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        // List<List<Integer>> result = new ArrayList<>();
        // boolean[] set = new boolean[nums.length];
        // permutation(nums, result, set, new ArrayList<>());
        // return result;


        List<List<Integer>> result = new ArrayList<>();
        Permutations(0, nums, result);
        return result;

    }
}