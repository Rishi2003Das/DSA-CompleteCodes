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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        dfs(0,root,ans);
        return ans;
    }
    void dfs(int level, TreeNode node, List<Integer> ans){
        if(node==null)
        return;
        if(level==ans.size()){
            ans.add(node.val);
        }
        if(node.right!=null){
            dfs(level+1,node.right,ans);
        }
        if(node.left!=null){
            dfs(level+1,node.left,ans);
        }
        return;
    }
}
