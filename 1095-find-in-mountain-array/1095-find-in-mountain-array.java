/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int BinarySearch(int target, int left, int right, MountainArray mountainArr, boolean ascending) {
        // Binary search for ascending and descending orders
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleElement = mountainArr.get(middle);
            if (target == middleElement) {
                return middle;
            }
            if (ascending) {
                if (target > middleElement) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (target < middleElement) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int middleElement = mountainArr.get(mid);
            if (middleElement < mountainArr.get(mid+1)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        // find the mountain peekIndex
        int peakIndex = left;
        if (mountainArr.get(peakIndex) == target) {
            return peakIndex;       // if the peek itself is the mountain return it
        }
        int leftIndex = BinarySearch(target, 0, peakIndex - 1, mountainArr, true); // check for the left part for smallest index of target
        if (leftIndex != -1) {
            return leftIndex; // if target is found return the index
        }
        return BinarySearch(target, peakIndex + 1, n - 1, mountainArr, false); // if its not on left part, search the right part. If its their in right part it returns the index or -1;

    }
}