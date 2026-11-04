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

    static int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(findMaxPathSum(root.left), 0);
        int right = Math.max(findMaxPathSum(root.right), 0);
        
        int pathSum = root.val + left + right;
        maxSum = Math.max(maxSum, pathSum);

        return root.val + Math.max(left, right);
    }
}