import java.util.*;
public class DisjointSet_Graph {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank= new ArrayList<>();
    public DisjointSet_Graph(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
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
}

class Main {
    public static void main(String[] args) {
        DisjointSet_Graph ds = new DisjointSet_Graph(5);
        ds.unionByRank(0, 1);
        ds.unionByRank(1, 2);
        ds.unionByRank(3, 4);
        
        System.out.println(ds.findParent(0)); // Output: 0
        System.out.println(ds.findParent(1)); // Output: 0
        System.out.println(ds.findParent(2)); // Output: 0
        System.out.println(ds.findParent(3)); // Output: 3
        System.out.println(ds.findParent(4)); // Output: 3
    }
}
