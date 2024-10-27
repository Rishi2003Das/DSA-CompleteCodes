class DFS {

  // dfs using stack
  void dfsStack(Node node) {
    if(node == null) {
      return;
    }
    ArrayList<Integer> ans=new ArrayList<>();
    
    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()) {
      Node removed = stack.pop();
      ans.add(removed.val);
      if(removed.right != null) {
        stack.push(removed.right);
      }
      if(removed.left != null) {
        stack.push(removed.left);
      }
    }
    return ans;
  }
}
