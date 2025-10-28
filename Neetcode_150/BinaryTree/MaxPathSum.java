class Solution {
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    int helper(TreeNode node) {
        if (node == null) return 0;

        // Get left and right max path sum; ignore negative paths
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // Compute the path sum passing through current node
        int pathSum = node.val + left + right;
        
        // Update global max
        ans = Math.max(ans, pathSum);

        // Return max gain including current node to parent
        return node.val + Math.max(left, right);
    }
}
