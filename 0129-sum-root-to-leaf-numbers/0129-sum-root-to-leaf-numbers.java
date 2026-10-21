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
    int result;
    public void find(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += currentSum;
        }
        find(root.left, currentSum);
        find(root.right, currentSum);
    }
    public int sumNumbers(TreeNode root) {
        result = 0;
        find(root, 0);
        return result;
    }
}