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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] cur: descriptions) {
            TreeNode parent = nodes.computeIfAbsent(cur[0], k -> new TreeNode(cur[0]));
            TreeNode child = nodes.computeIfAbsent(cur[1], k -> new TreeNode(cur[1]));
            if(cur[2] == 0) parent.right = child;
            else parent.left = child;
            children.add(cur[1]);
        }

        for(Integer key: nodes.keySet()) {
            if(!children.contains(key)) return nodes.get(key);
        }

        return null;
    }
}