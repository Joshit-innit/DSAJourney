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
    TreeNode xParent ;
    TreeNode yParent ;
    int x;
    int y;
    public int depth(TreeNode root, int target, TreeNode parent) {
        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            if (target == x) {
                xParent = parent;
            }
            else {
                yParent = parent;
            }
            return 0;
        }

        int left = depth(root.left, target, root);
        if (left != -1) {
            return left + 1;
        }
        int right = depth(root.right, target, root);
        if (right != -1) {
            return right + 1;
        }
        return -1;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
    int xDepth = depth(root, x, null);
    int yDepth = depth(root, y, null);

    if (xParent == yParent) {
        return false;
    }

    if (xDepth != yDepth) {
        return false;
    }
    return true;
        
    }
}