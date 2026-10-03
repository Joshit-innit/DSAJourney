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
    public List<String> result = new ArrayList<>();
    public void find(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        path += "->";

        find(root.right, path);
        find(root.left, path);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        find(root, "");
        return result;
        
    }
}