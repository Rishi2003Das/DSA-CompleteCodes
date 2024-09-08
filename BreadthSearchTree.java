import java.util.*;
public class TreeNode {
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
  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer> currLevel=new ArrayList<>(level);
            for(int i=0;i<level;i++){
                TreeNode curr=queue.poll();
                currLevel.add(curr.val);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
 }
