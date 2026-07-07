class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // HashSet<Integer> set = new HashSet<>();
        // for (int num : nums1) {
        //     set.add(num);
        // }
        // for (int num : nums2) {
        //     if (set.contains(num)) {
        //         return num;
        //     }
        // }

        // return -1;

        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        if(nums1[0] > nums2[m-1] || nums1[n-1] < nums2[0]) {
            return -1;
        } 
        while(i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }else if (nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        return -1;
    }
}