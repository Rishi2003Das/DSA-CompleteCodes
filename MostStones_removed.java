import java.util.*;
class DisjointSet {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node))
        return node;
        int root = findParent(parent.get(node));
        parent.set(node, root); // Path compression
        return root;
    }

    public void unionByRank(int u, int v){
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU == rootV) return; // They are already in the same set

        // Union by rank
        if (rank.get(rootU) < rank.get(rootV)) {
            parent.set(rootU, rootV);
        } else if (rank.get(rootU) > rank.get(rootV)) {
            parent.set(rootV, rootU);
        } else {
            parent.set(rootV, rootU);
            rank.set(rootU, rank.get(rootU) + 1);
        }
    }

    public void unionBySize(int u, int v){
        int rootU=findParent(u);
        int rootV=findParent(v);

        if(rootU == rootV)
        return;

        else if(size.get(rootU)<size.get(rootV)){
            parent.set(rootU, rootV);
            size.set(rootV,(size.get(rootU)+size.get(rootV)));
        }

        else{
            parent.set(rootV,rootU);
            size.set(rootU,(size.get(rootU)+size.get(rootV)));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0;
        int maxCol=0;

        for(int i=0;i<n;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }

        DisjointSet ds=new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow=stones[i][0];
            int nodeCol=stones[i][1]+maxRow+1;

            ds.unionBySize(nodeRow,nodeCol);
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeCol,1);
        }

        int cnt=0;
        for(Map.Entry<Integer, Integer> it:stoneNodes.entrySet()){
            if(ds.findParent(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}
