/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int find(int[] arr, int n) {
        int operations = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int sortedArray[] = arr.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArray[i]) {
                int index = map.get(sortedArray[i]);
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

                map.put(arr[index], index);

                operations++;
            }
        }

        return operations;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int changes = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                arr[i] = node.val;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            }

            changes += find(arr, size);
        }
        return changes;
    }
}