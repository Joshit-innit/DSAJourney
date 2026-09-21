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

    public Deque<Integer> searchLeaf(TreeNode root, Deque<Integer> q) {
        if (root == null) {
            return q;
        }

        if (root.left == null && root.right == null) {
            q.addFirst(root.val);
            return q;
        }
        searchLeaf(root.left, q);
        searchLeaf(root.right, q);
        return q;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<Integer> q1 = searchLeaf(root1, new ArrayDeque<>());
        Deque<Integer> q2 = searchLeaf(root2, new ArrayDeque<>());

        if (q1.size() != q2.size()) {
            return false;
        }

        while (!q1.isEmpty()) {
            if (!q1.pollFirst().equals(q2.pollFirst())) {
                return false;
            }
        }

        return true;

    }
}