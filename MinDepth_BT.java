class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
        return 0;

        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);
        if(root.left==null && root.right==null)
        return 1;
        if(root.left == null)
        return 1+rightDepth;
        if(root.right == null)
        return 1+leftDepth;

        return Math.min(leftDepth, rightDepth)+1;
    }
}
