//This is a TopoSort algorithm used pattern prediction question

class Solution {
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj=new ArrayList<Integer>();
        for(int i=0;i<N-1;i++){
            String p=dict[i];
            String q=dict[i+1];
            int m=p.length();
            int n=q.lenght();
            int c=0;
            while(m>0 && n>0){
                if(p.charAt(c)!=q.charAt(c)){
                    int a=(int)p.charAt(c)-97;
                    int b=(int)q.charAt(c)-97;
                    adj.get(a).add(b);
                    break; 
                }
                m--;
                n--;
                c++;
            }
        }
        return topoSort(K,adj);
    }
    public char[] topoSort(int V, List<List<Integer>> adj) {
    int vis[]=new int[V];
    int ans[]=new int[V];
    char fin[]=new char[V];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<V; i++){
        if(vis[i]==0)
        dfs(i, vis, st, adj);
    }
    for(int i=0;i<V;i++){
        ans[i]=st.peek();
        st.pop();
    }
    for(int i=0;i<V;i++){
        fin[i]=(char)(ans[i]+97);
    }
    return fin;
    }
    public static void dfs(int node, int vis[], Stack<Integer> st, List<List<Integer>> adj){
        vis[node]=1;
        for(int it : adj.get(node)){
            if(vis[it]==0)
            dfs(it,vis,st,adj);
        }
        st.push(node);
    }
}
