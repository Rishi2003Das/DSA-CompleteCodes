class Solution {
    public int timeToBurnTree(TreeNode root, int start) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode res=new TreeNode(-1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if(node.data == start)
                res=node;
                if (top.left != null) {
                    parent.put(top.left.val, top);
                    queue.offer(top.left);
                }

                if (top.right != null) {
                    parent.put(top.right.val, top);
                    queue.offer(top.right);
                }
            }
        }
        Map<Integer, Boolean> visMap = new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(res);
        int k=0;
        int f=0;
        while(!q.isEmpty()){
            f=0;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !visMap.containsKey(node.left)){
                    f=1;
                    vis.put(node.left,true);
                    q.offer(node.left);
                }
                if(node.right!=null && !visMap.containsKey(node.right)){
                    f=1;
                    vis.put(node.right,true);
                    q.offer(node.right);
                }
                if(parent.get(node) != null && visMap.get(parent.get(node))==null){
                    f=1;
                    vis.put(parent.get(node),true);
                    q.offer(parent.get(node));
                }

            }
            if(f==1)
            k++;
        }
        return k;
    }
}
