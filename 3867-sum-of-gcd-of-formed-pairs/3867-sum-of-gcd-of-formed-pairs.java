class Solution {
    public int gcd(int a, int b) {
        return (b == 0)?a:gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int prefixGCD[] = new int[n];
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefixGCD);
        long sum = 0;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            sum += gcd(prefixGCD[left], prefixGCD[right]);
            left++;
            right--;
        }
        return sum;

    }
}