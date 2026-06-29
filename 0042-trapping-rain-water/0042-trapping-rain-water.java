class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 1) {
            return 0;
        }
        int l = 0;
        int r = n - 1;
        int leftmax = height[l];
        int rightmax = height[r];
        int water = 0;
        while (l < r) {
            if (leftmax < rightmax) {
                l++;
                leftmax = Math.max(leftmax, height[l]);
                water += leftmax - height[l];
            }
            else {
                r--;
                rightmax = Math.max(rightmax, height[r]);
                water += rightmax - height[r];
            }
        }

        return water;
    }
}