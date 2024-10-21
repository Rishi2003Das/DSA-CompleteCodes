class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue= new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        int c=0;
        for(ArrayList<Integer> sublist : adj){
            if(!sublist.isEmpty()){
                c++;
            }
        }
        boolean vis[] = new boolean[c+1];
        
        queue.add(0);
        vis[0] = true;
        
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);
            
            for(Integer it:adj.get(node)){
                if(vis[it] == false){
                    vis[it]=true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }
}
