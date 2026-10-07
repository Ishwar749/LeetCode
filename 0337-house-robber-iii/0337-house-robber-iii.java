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
    public int rob(TreeNode root) {
        int[] values = new int[2];
        rob(root, values);

        return Math.max(values[0], values[1]);
    }

    private void rob(TreeNode root, int[] values) {
        if (root == null) {
            return;
        }

        int[] leftVals = new int[2];
        int[] rightVals = new int[2];

        rob(root.left, leftVals);
        rob(root.right, rightVals);

        values[0] = root.val + leftVals[1] + rightVals[1];
        values[1] = Math.max(leftVals[0], leftVals[1]) + Math.max(rightVals[0], rightVals[1]);
    }
}