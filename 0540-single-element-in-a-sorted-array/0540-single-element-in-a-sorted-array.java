class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int ans = 0;
        // for (int num : nums) {
        //     ans = ans ^ num;  // same numbers get cancel due to XOR operator but the single digit remains at the last
        // }
            
        // return ans;

        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 != 0) mid = mid - 1;
            if (nums[mid] == nums[mid+1]) {
                
                left = mid + 2;
            }else{
                right = mid;
            }
           
        }

        return nums[left];

    }
}