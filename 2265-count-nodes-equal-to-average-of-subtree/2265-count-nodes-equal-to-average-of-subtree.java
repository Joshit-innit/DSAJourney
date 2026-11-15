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

    public int result = 0;
    public int sumOfSubTree(TreeNode root) {
       if (root == null) {
        return 0;
       }
        return root.val + sumOfSubTree(root.right) + sumOfSubTree(root.left);
    }
    public int nodesCount (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodesCount(root.right) + nodesCount(root.left);
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (sumOfSubTree(root) / nodesCount(root) == root.val) {
            result++;
        }
        averageOfSubtree(root.right);
        averageOfSubtree(root.left);

        return result;
    }
}