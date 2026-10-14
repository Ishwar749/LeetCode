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
    private int preorderIndex = 0;
    private Map<Integer, Integer> mapping = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;

        TreeNode current = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;

        int inorderIndex = mapping.get(current.val);

        current.left = build(preorder, start, inorderIndex - 1);
        current.right = build(preorder, inorderIndex + 1, end);

        return current;
    }
}