//Adjacency Matrix for undirected graph
import java.util.*;
public class Solution {
    public void adjmatrix() {
        //Write your code here...
        Scanner sc= new Scanner(System.in);
        
        int n=sc.nextInt();
        int e= sc.nextInt();
        
        int adj[][]=new int[n][n];
        
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u-1][v-1]=1;
            adj[v-1][u-1]=1;
        }
        
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
             System.out.print(adj[i][j]+" ");   
            }
            System.out.println();
        }
    }
}

//Adjacency List for undirected graph
import java.util.*;

public class Solution {
    public static List<List<Integer>> adjList() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int E = scanner.nextInt();

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            List<Integer> edge = new ArrayList<>();
            edge.add(scanner.nextInt());
            edge.add(scanner.nextInt());
            edges.add(edge);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        return adj;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ans = Solution.adjList();

        for (int i = 1; i < ans.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(" -> " + ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
*/
