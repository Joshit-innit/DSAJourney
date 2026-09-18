class Solution {
    public void swap(int j, int index, int nums[]) {
        int temp = nums[j];
        nums[j] = nums[index];
        nums[index] = temp;
    }
    public void reverseFromIndex(int index, int nums[], int n) {
        if (index == n - 1) {
            return;
        }

        int start = index + 1;
        int end = n - 1;

        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverseFromIndex(index, nums, n);
            return;
        }
        for (int j = n - 1; index < j; j--) {
            if (nums[j] > nums[index]) {
                swap(j, index, nums);
                break;
            }
        }

        reverseFromIndex(index, nums, n);

    }
}