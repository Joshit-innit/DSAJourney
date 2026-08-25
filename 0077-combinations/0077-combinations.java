class Solution {
    List<List<Integer>> result;
    public void combo(int number, int k, int n, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (number > n) {
            return;
        }

        list.add(number);
        combo(number+1, k, n, list);
        list.remove(list.size() - 1);
        combo(number+1, k, n, list);
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combo(1, k, n, new ArrayList<>());
        return result;
    }
}