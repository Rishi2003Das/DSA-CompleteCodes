//Djikstra's Algorithm with Priority Queue method
//Source is mutable according to this code
//If we had started with dist[0] and pq.add(new Pair(0,0)), then the source would have been fixed.
class Pair{
    private int distance;
    private int node;
    Pair(int x, int y){
        distance=x;
        node=y;
    }
}

class Solution{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj,
    int S){
        
        //distance array or answer
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        dist[i]=(int)(1e9);

        //min-heap through PriorityQueue
        PriorityQueue<Pair> pq= 
        new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);

        //intialisation with the source S
        dist[S]=0;
        pq.add(new Pair(0,S));

        while(pq.size() != 0){
            //Extract the Pair from the PriorityQueue
            int dis=pq.peek().distance;
            int node=pq.peek().node;

            //removal of the Pair from the PriorityQueue
            pq.remove();

            for(int i=0;i<adj.get(node).size();i++){
                int Weight=adj.get(node).get(i).get(1);
                int Node=adj.get(node).get(i).get(0);

                if(dis+Weight<dist[Node]){
                    dist[Node]=dis+Weight;
                    pq.add(new Pair(dist[Node],Node));
                }
            }
        }

        return dist;

    }
}
