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
    List<List<Integer>> result = new ArrayList<>();
    int target;
    public void find (TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }

        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        find(root.right, sum, list);
        find(root.left, sum, list);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        
        find (root, 0, new ArrayList<>());
        return result;
    }
}