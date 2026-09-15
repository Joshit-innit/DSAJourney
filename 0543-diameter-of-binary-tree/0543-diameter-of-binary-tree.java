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
    int diameter = 0;
    public int find(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = find(root.left);
        int r = find(root.right);
        diameter = Math.max(diameter, l + r + 2);
        return 1 + Math.max(l, r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        find(root) ;
        return diameter;
    }
}