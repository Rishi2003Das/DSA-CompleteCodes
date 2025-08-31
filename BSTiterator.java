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
class BSTIterator {

    private Stack<TreeNode> stack=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    public int next() {
        TreeNode node=stack.pop();
        if(node.right!=null)
        pushLeft(node.right);

        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node){
        while(node!=null){
        stack.push(node);
        node=node. Left;
    }
    }
}
