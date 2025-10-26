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
    int count = 0;
    TreeNode result = null;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result.val;
    }

    private void helper(TreeNode node, int k) {
        if (node == null) return;

        helper(node.left, k);       // Traverse left
        count++;                    // Visit current
        if (count == k) {
            result = node;
            return;
        }
        helper(node.right, k);      // Traverse right
    }
}
