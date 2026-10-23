/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mark_parents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.right != null) {
                map.put(current.right,current);
                queue.offer(current.right);
            }
            if (current.left != null) {
                map.put(current.left, current);
                queue.offer(current.left);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        mark_parents(root, map);
        int level = 0;
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        visited.put(target, true);
        queue.offer(target);


        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                break;
            }
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();


                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (map.get(current) != null && visited.get(map.get(current)) == null) {
                    queue.offer(map.get(current));
                    visited.put(map.get(current), true);
                }
            }
        }



        List<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }

        return result;
    }
}