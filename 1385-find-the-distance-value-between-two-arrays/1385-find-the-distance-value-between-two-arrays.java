class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr2);
        for (int num: arr1) {
            int index = lowerBound(arr2, num);
            boolean valid = true;

            if (index < m && Math.abs(arr2[index] - num) <= d) {
                valid = false;
            }
            if (index > 0 && Math.abs(arr2[index - 1] - num) <= d) {
                valid = false;
            }

            if (valid) {
                result++;
            }
            
        }
        return result;
    }
    public int lowerBound (int[] arr2, int x) {
        int left = 0;
        int n = arr2.length;
        int right = n - 1;
        int ans = n; 
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr2[mid] >= x) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
    }
}