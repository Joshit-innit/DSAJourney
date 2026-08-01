class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int index = k / fact;
            sb.append(numbers.get(index));
            numbers.remove(index);

            if (numbers.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }

        return sb.toString();

    }
}