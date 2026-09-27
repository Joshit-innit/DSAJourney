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
    List<List<Integer>> result;
    public void find(Deque<TreeNode> q, Deque<List<Integer>> stack) {
        while (!q.isEmpty()) {
             int size = q.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }

            }
                stack.addFirst(list);


        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        Deque<List<Integer>> stack = new ArrayDeque<>();
        result = new ArrayList<>();
        find(q, stack);
        return result;
    }
}