class Solution {
    public int numOfSubarrays(int[] arr) {
        int result = 0;
        int oddcount = 0;
        int evencount = 0;
        int current = 0;
        int MOD = 1_000_000_007;
        for (int num : arr) {
            current += num;

            if (current % 2 != 0) {
                result = (result + 1 + evencount) % MOD;
                oddcount += 1;
            }
            else {
                result = (result + oddcount) % MOD;
                evencount += 1;
            }
        }


        return result;
    }
}