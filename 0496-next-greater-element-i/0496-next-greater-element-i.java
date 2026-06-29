class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int index = 0;index < m; index++) {
            map.put(nums1[index], index);
        }
        int result[] = new int[m];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            

            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int value = stack.pop();
                int indexOfValue = map.get(value);
                result[indexOfValue] = nums2[i];
            }

            if (map.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }

        return result;
    }
}