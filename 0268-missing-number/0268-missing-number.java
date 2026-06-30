class Solution {
    public int missingNumber(int[] nums) {
        // 0 + 1 + 2 + 3 = 6
        // 0 + 1 + 3 = 4
        int n = nums.length;
        int Actualsum = n * (n + 1 )/ 2;
        int sum = 0;
        for (int num : nums)  sum += num;
        return Actualsum - sum;

    }
}