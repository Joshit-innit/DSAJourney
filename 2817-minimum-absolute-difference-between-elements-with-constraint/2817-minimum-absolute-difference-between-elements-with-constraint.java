class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int minAns = Integer.MAX_VALUE;
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        for (int j = n - x - 1; j >= 0; j--) {
            set.add(nums.get(j + x));

            Integer lower = set.lower(nums.get(j) + 1); // here the +1 is to find the <= element, but the treeSet strictly finds the smaller element....so we add +1 to adjust it
            Integer higher = set.higher(nums.get(j));

            if (lower != null) {
                minAns = Math.min(minAns, Math.abs(lower - nums.get(j)));
            }
            if (higher != null) {
                minAns = Math.min(minAns, Math.abs(higher - nums.get(j)));
            }
        }
        return minAns;
    }
}