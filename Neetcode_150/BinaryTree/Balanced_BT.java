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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true;
        int lh=findHeight(root.left);
        int rh=findHeight(root.right);

        if(Math.abs(lh-rh)>1) return false;

        boolean l=isBalanced(root.left);
        boolean r=isBalanced(root.right);

        if(!l || !r) return false;

        return true;
    }

    int findHeight(TreeNode node){
        if (node==null) return 0;
        int l=findHeight(node.left);
        int r=findHeight(node.right);
        return Math.max(l,r)+1;
    }
}
