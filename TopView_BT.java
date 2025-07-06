/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Pair{
    private TreeNode node;
    private int col;
    Pair(TreeNode n, int c){
        this.node=n;
        this.col=c;
    }
}
class Solution {
    public List<Integer> topView(TreeNode root) {
        //your code goes here
        List<Integer> ans=new ArrayList<>();
        Queue<Pair> queue=new LinkedList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        queue.offer(new Pair(root, 0));
        if(!queue.isEmpty()){
            Pair out=queue.poll();

            TreeNode node=queue.node;
            int col=queue.col;
            if(!map.containsKey(col))
            map.put(col,node.data);
            if(node.left!=null){
                queue.add(new Pair(node.left,col-1));
            }
            if(node.right!=null)
            queue.add(new Pair(node.right,col+1));
        }

        for(HashMap.Entry<Integer,Integer> i : map.entrySet()){
            ans.add(i.getValue());
        }
        return ans;
    }
}
