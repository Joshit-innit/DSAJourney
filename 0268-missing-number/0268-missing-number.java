class Solution {
    public int missingNumber(int[] nums) {
        // 0 + 1 + 2 + 3 = 6
        // 0 + 1 + 3 = 4
        int n = nums.length;
        // int Actualsum = n * (n + 1 )/ 2;
        // int sum = 0;
        // for (int num : nums)  sum += num;
        // return Actualsum - sum;


        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left)/ 2;

            if(mid== nums[mid]) {
                left = mid + 1;
            }
            else {
                ans = mid;
                right = mid - 1;
            }
        }

        return (ans == - 1)?n:ans;

    }
}