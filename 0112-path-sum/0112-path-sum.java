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
    int targetSum;
    public boolean find (TreeNode root, int currentSum) {
        if (root == null) {
            return false;
        }
        currentSum += root.val; 
        if (root.right == null && root.left == null) {
            return targetSum == currentSum;
        }
        
        return find(root.left, currentSum) || find(root.right, currentSum );
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return find(root, 0);
    }
}