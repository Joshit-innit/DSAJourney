class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        int n = arr.length;
        int mid = 0;
        while (i <= j) {
             mid = (i+j)/2;
            
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                i = mid + 1;
            }
            else {
                j = mid - 1;
            }
        }

        return i + k;
    }
}