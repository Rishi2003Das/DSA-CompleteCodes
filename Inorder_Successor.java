class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Inorder_Succ {
    int succ=-1;
    public int Success(TreeNode root, int value){
        if(root==null) {
        return succ;
        }
        if(root.val>value && (succ==-1 || root.val<succ)){
        succ=root.val;
        return Success(root.left, value);
        }
        else{
        return Success(root.right, value);
        }
    }
    public static void main(String args[]){
        Inorder_Succ obj=new Inorder_Succ();
        TreeNode root=new TreeNode(20);
        root.left=new TreeNode(8);
        root.right=new TreeNode(22);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(11);
        root.left.right.left=new TreeNode(10);
        root.left.right.right=new TreeNode(14);
        int value=8;
        int result=obj.Success(root, value);
        System.out.println("Inorder Successor of "+value+" is: "+result);
    }
}
