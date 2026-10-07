/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        System.out.println(sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("*,");
            return;
        }

        sb.append(root.val+",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] ind = {0};

        return deserialize(vals, ind);
    }

    private TreeNode deserialize(String[] data, int[] ind) {
        if (ind[0] >= data.length) {
            return null;
        }

        if (data[ind[0]].equals("*")) {
            ind[0]++;
            return null;
        }

        int val = Integer.parseInt(data[ind[0]]);
        ind[0]++;
        
        TreeNode current = new TreeNode(val);
        current.left = deserialize(data, ind);
        current.right = deserialize(data, ind);

        return current;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));