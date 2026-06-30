class Solution {
    public int LowerBoundIndex(int[] temp, int target, int n) {
        int left = 0;
        int right = n - 1;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (temp[mid] >= target) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
    }
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] temp = new int[n];
        long originalDiff = 0;
        for (int i = 0; i < n; i++) {
            temp[i] = nums1[i];
            originalDiff += Math.abs(nums1[i] - nums2[i]);
        }
        if (originalDiff == 0) return 0;
        long ans = Long.MAX_VALUE;
        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            int initial = Math.abs(nums1[i] - nums2[i]);
            int index = LowerBoundIndex(temp, nums2[i], n);
            int finall = initial;
            if (index < n) {
                finall = Math.min(finall, Math.abs(temp[index] - nums2[i]));
            }
            if (index > 0) {
                finall = Math.min(finall, Math.abs(temp[index - 1] - nums2[i]));
            }

            ans = Math.min(ans, originalDiff - (initial - finall));
        }
        return (int)(ans % 1000000007);
    }
}