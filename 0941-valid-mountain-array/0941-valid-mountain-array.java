class Solution {
    public boolean validMountainArray(int[] arr) {
        int index = 1;
        int n = arr.length;
        if (n < 3) {
            return !true;
        }

        while(index < n && arr[index] > arr[index - 1]) {
            index++;
        }

        if (index == 1 || index == n) {
            return false;
        }
        
        while(index < n && arr[index] < arr[index - 1]) {
            index++;
        }
        

        return index==n;
    }
}