class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0;i<levelSize;i++){
                TreeNode curr = queue.poll();

                if(i == (levelSize -1)){
                    result.add(curr.val);
                }

                if(curr.left!=null)
                queue.offer(curr.left);

                if(curr.right!=null)
                queue.offer(curr.right);

            }
        }
        return result;
    }
}
