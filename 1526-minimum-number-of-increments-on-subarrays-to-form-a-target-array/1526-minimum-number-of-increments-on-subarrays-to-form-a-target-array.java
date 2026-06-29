class Solution {
    public int minNumberOperations(int[] target) {
        int result = target[0];
        int n = target.length;
        for (int i = 1; i < n; i++) {
            result += Math.max(target[i] - target[i-1], 0);
        }

        return result;
    }
}