class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int n = arr.length;
        int right = n - 1;
        int peak = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;

            if (mid < n - 1 && arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            }
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                peak = mid;
                break;
            }
        }
        return peak;

    }
}